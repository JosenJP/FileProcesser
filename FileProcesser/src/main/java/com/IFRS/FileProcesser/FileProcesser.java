package com.IFRS.FileProcesser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;;

public class FileProcesser
{   
    private File file;
    private int lineNum;
    
    public FileProcesser(String fileName)
    {
        file = new File(fileName);
        lineNum = 0;
    }
    
    public String ReadLine()
    {
        String content = null;
        LineNumberReader reader = null;
        try
        {
            reader = new LineNumberReader(new FileReader(file));
            
            reader.setLineNumber(lineNum);
            content = reader.readLine();
            
            lineNum = reader.getLineNumber();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if (null != reader)
            {
                try
                {
                    reader.close();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        return content;
    }
    
    
}
