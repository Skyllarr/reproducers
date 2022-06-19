import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        System.setSecurityManager(new SecurityManager());
        SSLContext sslContext =  SSLContext.getDefault();

        System.out.println("Number of enabled cipher suites is: " + sslContext.createSSLEngine().getEnabledCipherSuites().length);
        System.out.println("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 is among supported cipher suites: " +
                Arrays.asList(sslContext.getSupportedSSLParameters().getCipherSuites()).contains("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"));

    }
}
