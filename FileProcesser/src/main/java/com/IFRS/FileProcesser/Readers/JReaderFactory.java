package com.IFRS.FileProcesser.Readers;

import java.io.*;

public class JReaderFactory
{
    public static BufferedReader GetReader(ReadType readType, File file) throws FileNotFoundException
    {
        BufferedReader bufferedReader = null;
        
        switch (readType)
        {
        case Line:
        {
            bufferedReader = new LineNumberReader(new FileReader(file));
            break;
        }
        case Random:
        {
            break;
        }
        default:
        {
            break;
        }
        }
        
        return bufferedReader;
    }
}
