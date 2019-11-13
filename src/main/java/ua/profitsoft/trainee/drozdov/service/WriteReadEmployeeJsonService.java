package ua.profitsoft.trainee.drozdov.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ua.profitsoft.trainee.drozdov.employee.Employee;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class WriteReadEmployeeJsonService {

    private static WriteReadEmployeeJsonService instance;

    private WriteReadEmployeeJsonService() {
    }

    public static WriteReadEmployeeJsonService getInstance() {
        if (instance == null) {
            instance = new WriteReadEmployeeJsonService();
        }
        return instance;
    }

    /**
     * Create new directory If pathFile contains directory, and add JSON file.
     * @param pathFile
     * @param employees
     * @throws IOException
     */
    public void write(String pathFile, List<Employee> employees) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        StringTokenizer stringTokenizer = new StringTokenizer(pathFile, "/");
        StringBuilder stringBuilder = new StringBuilder();
        File file;

        if(stringTokenizer.countTokens()>1) {
            while (stringTokenizer.countTokens() > 1) {
                stringBuilder.append(stringTokenizer.nextToken());
                stringBuilder.append(File.separator);

            }
            File newDirectory = new File(stringBuilder.toString());
            newDirectory.mkdirs();
            file = new File(newDirectory + File.separator + stringTokenizer.nextToken());
        }else{
            file = new File(pathFile);
        }

        mapper.writeValue(file, employees);

    }
    public List<Employee> readEmployee(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Employee> employees = Arrays.asList(objectMapper.readValue(new File(filePath), Employee[].class));
        return employees;
    }
}
