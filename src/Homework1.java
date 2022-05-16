import java.io.*;

public class Homework1 {
    public static void main(String[] args) {
        String fileName = "property.html";

        try {
            File file = new File(fileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("<!DOCTYPE html>\r\n<html lang=\"ko\">\r\n");
            writer.write("<head>");
            writer.write("<h1>자바 환경정보</h1>");
            writer.write("\r\n\t <meta charset=\"UTF-8\"/>");
            writer.write("\r\n\t <style>\r\n\t\t");
            writer.write("table {border-collapse:collapse; width:100%;text-align:left;}");
            writer.write("\r\n\t\t th,td{border:solid 1px #000}\n\t </style>\n </head>");
            writer.write("<body><table>");
            writer.write("<center><tr>\r\n<th>키</th>\r\n");
            writer.write("  <td>값</td>\r\n </tr></center>\r\n");

            for(Object k: System.getProperties().keySet()){
                String key = k.toString();
                String value = System.getProperty(key);
                writer.write("<tr>\r\n <th>"+key+"</th>\r\n");
                writer.write("  <td>"+value+"</td>\r\n </tr>\r\n");
            }

            writer.write("</table>\r\n</body>\r\n</html>\r\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
