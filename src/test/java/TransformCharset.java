import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: WinningRsult
 * @date 2016年07月01日 17:55
 * @Copyright (c) 2015-2020 by caitu99
 */
public class TransformCharset {
    private final static String SOURCE_ENCODING = "GBK"; // 源代码字符集
    private final static String TARGET_ENCODING = "UTF-8"; // 转换后代码字符集
    private static String SOURCE_DIR = "/home/babe/a"; // 源代码所在位置
    private static String TARGET_DIR = "/home/babe/b"; // 转后字符集后代码存放位置
    private static String[] ext_names = { "java" }; // extension name

    private static FileInputStream fin = null;
    private static FileOutputStream fout = null;
    private static FileChannel fcin = null;
    private static FileChannel fcout = null;
    private static File tmp = null;
    private static int filenumber = 0;
    private static int encodefilenum = 0;
    private static int excodefilenum = 0;
    private static ByteBuffer buffer;

    // exchange中使用的变量
    private static File targetDirectory;
    private static File sourceDirectory;
    private static File[] childs;

    private static String filename;
    private static boolean decodeflag = false;

    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis(); // 获取开始时间

            targetDirectory = new File(TARGET_DIR);
            if (targetDirectory.exists()) {
                targetDirectory.delete();
            } else {
                targetDirectory.mkdirs();
            }

            exchange(SOURCE_DIR);

            long endTime = System.currentTimeMillis(); // 获取结束时间
            long counttime = endTime - startTime;
            if (counttime > 1000)
                System.out.println("程序运行时间： " + counttime / 1000 + "秒");
            else
                System.out.println("程序运行时间： " + counttime + "毫秒");
            System.out.println("转换了" + encodefilenum + "个文件！");
            System.out.println("未转换" + excodefilenum + "个文件！");
            System.out.println("总共" + filenumber + "个文件！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exchange(String srcDir) {

        sourceDirectory = new File(srcDir);
        if (sourceDirectory.exists()) {
            if (sourceDirectory.isFile()) {
                filenumber++;
                try {
                    fileEncodingExchange(sourceDirectory);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                childs = sourceDirectory.listFiles();
                for (File child : childs)
                    exchange(child.getPath());
            }
        }
    }

    private static void fileEncodingExchange(File infile) throws IOException {

        try {

            fin = new FileInputStream(infile);
            tmp = new File(TARGET_DIR
                    + infile.getPath().substring(SOURCE_DIR.length(),
                    infile.getPath().length()));

            if (!tmp.getParentFile().exists()) {
                tmp.getParentFile().mkdirs();
                if (!tmp.exists()) {
                    tmp.createNewFile();
                }
            }

            fout = new FileOutputStream(tmp);

            fcin = fin.getChannel();
            fcout = fout.getChannel();
            buffer = ByteBuffer.allocateDirect(1024);

            if (ext_names == null || ext_names.length == 0) {
                decodeflag = true;
                encodefilenum++;
// System.out.println(filename+"      转换");
            } else {
                filename = null;
                filename = infile.getName();
                for (String ext_name : ext_names) {
                    if (isonym(
                            filename.substring(filename.lastIndexOf(".") + 1),
                            ext_name)) {
                        decodeflag = true;
                        encodefilenum++;
// System.out.println(filename+"      转换");
                        break;
                    } else {
                        decodeflag = false;
                        excodefilenum++;
// System.out.println(filename+"      不转换");
                    }
                }
            }

            while (true) {
                buffer.clear();
                int r = fcin.read(buffer);
                if (r == -1) {
                    break;
                }
                buffer.flip();
                if (decodeflag) {
                    fcout.write(ByteBuffer.wrap(Charset
                            .forName(SOURCE_ENCODING).decode(buffer).toString()
                            .getBytes(TARGET_ENCODING)));
                } else {
                    fcout.write(buffer);

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                fin.close();
            }
            if (fcin != null) {
                fcin.close();
            }
            if (fout != null)
                fout.close();
            if (fcout != null)
                fcout.close();
        }
    }

    private static boolean isonym(String name1, String name2) {
        if (name1 != null && name2 != null) {
            return name1.toLowerCase().equals(name2.toLowerCase());
        } else {
            return false;
        }

    }
}


