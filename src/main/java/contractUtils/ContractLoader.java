package contractUtils;

import contract.TokenERC20;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */
public class ContractLoader {

    static TokenERC20 erc20 = null;

    public static TokenERC20 getContract() throws IOException, CipherException {
        if (erc20 == null) loadERC20();
        return erc20;
    }

    /**
     * loader for erc 20 token contract
     * */
    public  static void loadERC20() throws IOException, CipherException {

        System.out.println("Loading contract: ERC20");
        // Get or create Web3j instance
        Web3j web3j = Web3j.build(new HttpService(NodeConstants.WEB3_URL));

        // Get the node credentials
        Credentials NODE = WalletUtils.loadCredentials(NodeConstants.WalletFilePassword,
                NodeConstants.WalletFilePath);

        try {
            // load contract
            erc20 = TokenERC20.load(NodeConstants.contractAddress, web3j, NODE,
                    NodeConstants.GAS_PRICE, NodeConstants.GAS_LIMIT);
            // check if contract is valid
            assert erc20.isValid();
            System.out.println("Contract Address:" + erc20.getContractAddress());

        } catch (IOException ex) {
            System.out.println("io exception");
        } catch (Exception ex) {
            System.out.println("exception");
        }
    }
}
