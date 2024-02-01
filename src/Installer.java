import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Installer {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();

        // Путь к установке
        String directPath = "D://Games";

        // Директории
        String[] dirs = {
                directPath + "/src",
                directPath + "/res",
                directPath + "/savegames",
                directPath + "/temp",
                directPath + "/src/main",
                directPath + "/src/test",
                directPath + "/res/drawables",
                directPath + "/res/vectors",
                directPath + "/res/icons"
        };

        // Создаются директории
        for (String dir : dirs) {
            File directory = new File(dir);
            if (directory.mkdir()) {
                log.append("Директория ").append(dir).append(" успешно создана\n");
            } else {
                log.append("Не удалось создать директорию ").append(dir).append("\n");
            }
        }

        // Создаются файлы
        String[] files = {
                directPath + "/src/main/Main.java",
                directPath + "/src/main/Utils.java",
                directPath + "/temp/temp.txt"
        };

        // Создаются файлы
        for (String filePath : files) {
            try {
                File file = new File(filePath);
                if (file.createNewFile()) {
                    log.append("Файл ").append(filePath).append(" успешно создан\n");
                } else {
                    log.append("Не удалось создать файл ").append(filePath).append("\n");
                }
            } catch (IOException e) {
                log.append("Ошибка при создании файла ").append(filePath).append(": ").append(e.getMessage()).append("\n");
            }
        }

        // Записывается информация о результатах в файл (Log)
        try (FileWriter writer = new FileWriter(new File(directPath,"/temp/temp.txt"))) {
            writer.write(log.toString());
        } catch (IOException e) {
            System.out.println("Ошибка при записи лога: " + e.getMessage());
        }


    }
}