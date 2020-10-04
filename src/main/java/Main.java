import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Arrays;

import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;
import org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
        Security.insertProviderAt(new BouncyCastleFipsProvider(),1);
        Security.insertProviderAt(new BouncyCastleJsseProvider(("fips:BCFIPS")), 2);

        SSLContext sslContext = SSLContext.getInstance("TLSV1.2", BouncyCastleJsseProvider.PROVIDER_NAME);
        sslContext.init(null, null, null);

        System.out.println("Provider of SSL Context is: " + sslContext.getProvider().getName());
        System.out.println("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 is among supported cipher suites: " +
                Arrays.asList(sslContext.getServerSocketFactory().getSupportedCipherSuites()).contains("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384"));
    }
}
