package simulations;

import contract.TokenERC20;
import contractUtils.ContractLoader;
import contractUtils.NodeConstants;
import org.web3j.abi.datatypes.Int;
import org.web3j.crypto.CipherException;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import javax.xml.soap.Node;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */
public class Main {

    static TokenERC20 erc20 = null;

    static {
        try {
            erc20 = ContractLoader.getContract(); // load the contract if not already loaded.;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the balance of a wallet address
     * @param address Wallet Address of the account
     * @return total number of tokens in the provided wallet address
     * */
    public static BigInteger getBalanceOf(String address) throws Exception {
        BigInteger value =  erc20.balanceOf(address).send();
        return value;
    }

    /**
     * Get the total supply of the tokens
     * @return total number of supplied tokens of the loaded contract address
     * */
    public static BigDecimal getTotalSupply() throws Exception {
        BigInteger supply =  erc20.totalSupply().send();
        BigDecimal dSupply = new BigDecimal(supply).divide(NodeConstants.divideFactor); //change to BigDecimal and divide by 10^18
        return dSupply;
    }

    /**
     * Send some tokens to the another wallet
     * @param address wallet address of the receipent
     * @param tokens token value to send
     * @return transaction success status
     * */
    public static boolean sendToken(String address, BigInteger tokens) throws Exception {
        TransactionReceipt receipt = erc20.transfer(address, tokens).send();
        return ( receipt.getBlockHash().isEmpty() ? false : true ); // if empty then return false
    }



    /**
     * Implementing above functions
     * */
    public static void main(String[] args) throws Exception {
        erc20 = ContractLoader.getContract();   // load the contract if not already loaded.

        //get balance of an account
        BigInteger balance = getBalanceOf(NodeConstants.FirstWalletAddress);
        System.out.println("Balance of the first wallet address is : " + balance);

        //get the total supply of the tokens
        BigDecimal supply = getTotalSupply();
        System.out.println("Total Supply : "+ supply);

        //send 0.0001 token to my second wallet
        BigInteger tkn = BigDecimal.valueOf(0.0001).multiply(NodeConstants.divideFactor).toBigInteger();
        boolean tx = false;
        try {
             tx = sendToken(NodeConstants.SecondWalletAddress, tkn);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (tx){
            System.out.println("Transaction Successful !! ");}
        else{
            System.out.println("Failed to send !! ");
        }

    }
}
