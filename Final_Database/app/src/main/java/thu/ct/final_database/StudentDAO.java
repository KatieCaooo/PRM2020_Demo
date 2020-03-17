package thu.ct.final_database;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements Serializable {
    public StudentDAO() {
    }

    public List<StudentDTO> loadFromRaw(InputStream inputStream) {
        List<StudentDTO> result = new ArrayList<>();
        StudentDTO dto = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        String s = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            while ((s = bufferedReader.readLine()) != null) {
                String[] tmp = s.split("-");
                dto = new StudentDTO(tmp[0], tmp[1], Float.parseFloat(tmp[2]));
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public List<StudentDTO> loadFromInternal(FileInputStream fileOutputStream) {
        List<StudentDTO> result = new ArrayList<>();
        StudentDTO dto = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        String s = null;
        try {
            inputStreamReader = new InputStreamReader(fileOutputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            while ((s = bufferedReader.readLine()) != null) {
                String[] tmp = s.split("-");
                dto = new StudentDTO(tmp[0], tmp[1], Float.parseFloat(tmp[2]));
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void saveToInternal(FileOutputStream fileOutputStream, List<StudentDTO> studentDTO) {
        OutputStreamWriter outputStreamWriter = null;
        try {
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            String result = "";
            for (StudentDTO dto : studentDTO) {
                result += dto.toString() + "\n";
            }
            outputStreamWriter.write(result);
            outputStreamWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close connection
        }
    }

    public List<StudentDTO> loadFromExternal() {
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        File sdCard = Environment.getExternalStorageDirectory();
        String realPath = sdCard.getAbsolutePath();
        File directory = new File(realPath, "/myFile");
        directory.mkdir();
        File file = new File(directory, "hahaha.txt");

        List<StudentDTO> result = new ArrayList<>();
        StudentDTO dto = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        FileInputStream  fileInputStream = null;
        String s = null;
        try {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            while ((s = bufferedReader.readLine()) != null) {
                String[] tmp = s.split("-");
                dto = new StudentDTO(tmp[0], tmp[1], Float.parseFloat(tmp[2]));
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean saveToExternal(List<StudentDTO> list) {
        boolean check = false;
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        File sdCard = Environment.getExternalStorageDirectory();
        String realPath = sdCard.getAbsolutePath();
        File directory = new File(realPath, "/myFile");
        directory.mkdir();
        File file = new File(directory, "hahaha.txt");
        try {
            fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            String result = "";
            for (StudentDTO dto : list) {
                result += dto.toString() + "\n";
            }
            outputStreamWriter.write(result);
            outputStreamWriter.flush();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
