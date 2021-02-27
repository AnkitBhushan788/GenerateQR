import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRGenerate {

    // Driver code
    public static void main(String[] args) {

        // The data that the QR code will contain
       String data = "www.geeksforgeeks.org";

       String Enc= Base64.getEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));
        // The path where the image will get saved
        String path = "/home/ankit/QR/"+Data+".png";

        // Encoding charset
        String charset = "UTF-8";


        createQR(Enc, path, charset, 500, 500);

    }
    public static void createQR(String data, String path,String charset,int height, int width){

        try {
            BitMatrix matrix = new MultiFormatWriter().encode(
                    new String(data.getBytes(charset), charset),
                    BarcodeFormat.QR_CODE, width, height);

            MatrixToImageWriter.writeToFile(
                    matrix,
                    path.substring(path.lastIndexOf('.') + 1),
                    new File(path));
            System.out.println("QR Code Generated!!! ");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
