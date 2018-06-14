package com.fema.compilador.lexico;

import java.io.IOException;
import java.io.StringReader;

public class LanguageSextaFase {

    public static void main(String[] args) throws IOException {

        String expr = "if 2 + 3+a then";

        LexicalAnalyzer lexical = new LexicalAnalyzer(new StringReader(expr));
        lexical.yylex();

    }
    
    public static String analisador(String file) throws IOException{
    	LexicalAnalyzer lexical = new LexicalAnalyzer(new StringReader(file));
    	return lexical.yylex();
    }
    
}