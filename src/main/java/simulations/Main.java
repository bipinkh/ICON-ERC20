package simulations;

import contract.TokenERC20;
import contractUtils.ContractLoader;
import contractUtils.NodeConstants;
import org.web3j.abi.datatypes.Int;

import javax.xml.soap.Node;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */
public class Main {

    static TokenERC20 erc20 = null;

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
     * Implementing above functions
     * */
    public static void main(String[] args) throws Exception {
        erc20 = ContractLoader.getContract();   // load the contract if not already loaded.

        //get balance of an account
        BigInteger balance = getBalanceOf("0x627306090abaB3A6e1400e9345bC60c78a8BEf57");
        System.out.println("Balance of the provided address is : " + balance);

        //get the total supply of the tokens
        BigDecimal supply = getTotalSupply();
        System.out.println("Total Supply : "+ supply);
    }
}
