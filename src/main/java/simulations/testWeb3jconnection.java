package simulations;

import contractUtils.NodeConstants;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

public class testWeb3jconnection {

    public static void main(String[] args){
        Web3j web3j = Web3j.build(new HttpService(NodeConstants.WEB3_URL));
        try {
            Web3ClientVersion clientVersion = web3j.web3ClientVersion().sendAsync().get();
            System.out.println("Client version :: "+clientVersion.getWeb3ClientVersion());
        } catch (Exception e) {
            System.out.println("Exception getting client verion :: " + e.getMessage());
        }
    }

}
