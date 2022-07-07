//package logging;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.*;
//import java.nio.file.Files;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * Utility class for counting new unique visitors.
// *
// * @author Artem Boiko
// */
//public class VisitorsCounter {
//    private static final Logger logger = LogManager.getLogger(VisitorsCounter.class);
//    private static final Lock mutex = new ReentrantLock(true);
//    private String outsideDirectory;
//    private String logFile;
//    private Hash hashUtil;
//    private Loader propertyLoader;
//
//    private VisitorsCounter() {
//    }
//
//    /**
//     * Creates encryptedVisitorsIP log file if not exists.
//     * <p>
//     * Method invokes in AppContext class via Reflection API.
//     */
//    private void postProcessor() {
//        logFile = propertyLoader.getAppProperty("encrypted.visitors.cut.ips.log.file");
//        String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
//        File appDirectory = new File(path);
//        outsideDirectory = appDirectory.getParentFile()
//                                       .getParentFile()
//                                       .getParent() + System.getProperty("file.separator");
//        File encryptedVisitorsLog = new File(outsideDirectory + logFile);
//        try {
//            if (encryptedVisitorsLog.createNewFile()) {
//                try (FileOutputStream fileOutputStream = new FileOutputStream(encryptedVisitorsLog, true)) {
//                    logger.info(Messages.LOG_FILE_IS_CREATED);
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void refreshCount(HttpServletRequest request) {
//        try {
//            mutex.lock();
//
////            in case of Spring project with BCrypt dependency
////            String encodedVisitorIP = BCrypt.hashpw(request.getRemoteAddr(), getSalt());
//
//            String encodedVisitorIP = hashUtil.hash(request.getRemoteAddr());
//            String cutEncodedVisitorIP = cutIp(encodedVisitorIP);
//            List<String> visitorsEncodedData = readEncryptedVisitorsFile();
//            boolean isNew = checkIsUserNew(cutEncodedVisitorIP, visitorsEncodedData);
//            if (isNew) {
//                visitorsEncodedData.add(cutEncodedVisitorIP);
//                logger.info(Messages.AMOUNT_OF_UNIQUE_VISITORS, visitorsEncodedData.size());
//                writeCutEncryptedIP(encodedVisitorIP);
//            }
//        } finally {
//            mutex.unlock();
//        }
//    }
//
//    private String cutIp(String encodedVisitorIP) {
//        return encodedVisitorIP.substring(encodedVisitorIP.length() - 8);
//    }
//
//    private List<String> readEncryptedVisitorsFile() {
//        List<String> visitorsEncodedData = new ArrayList<>();
//        File file = new File(outsideDirectory + logFile);
//        try (InputStream inputStream = Files.newInputStream(file.toPath());
//             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
//            bufferedReader.lines().forEach(visitorsEncodedData::add);
//        } catch (IOException exception) {
//            logger.error(Messages.CANNOT_READ_FILE_PROPERLY, exception.getCause(), exception);
//        }
//        visitorsEncodedData.replaceAll(s -> s.substring(4));
//        return visitorsEncodedData;
//    }
//
//    private boolean checkIsUserNew(String cutEncodedVisitorIP, List<String> visitorsEncodedData) {
//        boolean isNew = true;
//        for (String data : visitorsEncodedData) {
//            if (cutEncodedVisitorIP.equals(data)) {
//                isNew = false;
//                break;
//            }
//        }
//        return isNew;
//    }
//
//    private void writeCutEncryptedIP(String encodedVisitorIP) {
//        try (FileOutputStream outputStream = new FileOutputStream(outsideDirectory + logFile, true)) {
//            String line = Constants.STARS + cutIp(encodedVisitorIP) + System.lineSeparator();
//            byte[] strToBytes = line.getBytes();
//            outputStream.write(strToBytes);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
