package com.IFRS.FileProcesser.Readers;

import java.io.IOException;
import java.io.LineNumberReader;

public class LineReader extends BaseReader
{
    private int lineNumber;
    
    public LineReader(String fileName)
    {
        super(fileName);
        lineNumber = 0;
        type = ReadType.Line;
    }
    
    public void SetLineNumber(int lineNumber)
    {
        this.lineNumber = lineNumber;
    }
    
    public String ReadLine()
    {
        String content = null;
        
        super.ReadLine();
        
        try
        {
            LineNumberReader tmpReader = (LineNumberReader)reader;
            
            tmpReader.setLineNumber(lineNumber);
            
            content = ((LineNumberReader)reader).readLine();
            
            lineNumber = tmpReader.getLineNumber();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        
        return content;
    }
}
