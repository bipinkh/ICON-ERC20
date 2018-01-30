package contractUtils;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */
public class NodeConstants {

    public static final String WEB3_URL = "https://mainnet.infura.io/";
    public static final BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    public static final BigInteger GAS_LIMIT = BigInteger.valueOf(6721975);
    public static String contractAddress = "0xb5a5f22694352c15b00323844ad545abb2b11028";

    // for 18 decimal places, divide factor = 10 ^ 18
    public static final BigDecimal divideFactor = BigDecimal.valueOf(Math.pow(10, 18));

    public static final String WalletFile = "UTC--2018-01-29T05-32-44.393Z--7507d5ccddb8b987638b27fd57ab862cc8fae116";
    public static final String WalletFilePath = "icon/firstwallet/"+WalletFile;
    public static final String WalletFilePassword = "i got this from sandip pandey";

    public static final String FirstWalletAddress = "0x7507d5ccDDB8B987638b27fd57Ab862cC8Fae116";
    public static final String SecondWalletAddress = "0xe7C960044b47B2804b2A230F324de2C8a079f4Bc";
}


