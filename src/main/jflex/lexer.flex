package com.daniel;

import java_cup.runtime.*;

%%

%class ExreganLexer
%unicode
%cup
%line
%column

%{

StringBuffer stringBuffer = new StringBuffer();

  // Return a symbol with the given symbol number and the given value.
  private Symbol symbol(int sym) {
      return new Symbol(sym, yyline, yycolumn);
  }

    // Return a symbol with the given symbol number and the given value.
  private Symbol symbol(int sym, Object value) {
        return new Symbol(sym, yyline, yycolumn, value);
  }
%}

// Init line and column
%init{
    yyline = 1;
    yycolumn = 1;
    yychar = 1;
%init}

// End of file token
%eofval{
    return new Symbol(sym.EOF);
%eofval}


// Non-ASCII characters
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

// ASCII GROUP 32-126

ASCII_32_126 = [\x20-\x2F\x3A-\x40\x5B-\x60\x7B-\x7E]


// Comments
Comment = {MultiLineComment} | {EndOfLineComment}

// MultiLineComment can be the last line of the file, without line terminator.
MultiLineComment   = "<!" [^*] ~"!>" | "<!" "!"+ ">"

// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
CommentContent       = ( [^*] | \*+ [^/*] )*

Identifier = [:jletter:] [:jletterdigit:]*

%state STRING

%%

// Keywords

<YYINITIAL> "CONJ" { return symbol(sym.CONJ); }

      <YYINITIAL> {

        // Identifiers
        {Identifier} { return symbol(sym.IDENTIFIER, yytext()); }

      // Literals
        \" { stringBuffer.setLength(0); yybegin(STRING); }

      // Separators
      "{" { return symbol(sym.LBRACE); }
      "}" { return symbol(sym.RBRACE); }
      ":" { return symbol(sym.COLON); }
      "->" { return symbol(sym.ARROW); }
      "%%" { return symbol(sym.PERCENTPERCENT); }
      "."  {  return symbol(sym.DOT); }
      "*" {  return symbol(sym.STAR); }
      "+" {  return symbol(sym.PLUS); }
        "?" {  return symbol(sym.QUERY); }
      "|" {  return symbol(sym.PIPE); }
      "~" {  return symbol(sym.TILDE); }
      "," {  return symbol(sym.COMMA); }
      "&" {  return symbol(sym.AMPERSAND); }

        // Comments
        {Comment} { /* ignore */ }

        // White space
        {WhiteSpace} { /* ignore */ }




      }

      <STRING> {
        \" { yybegin(YYINITIAL); return symbol(sym.STRING_LITERAL, stringBuffer.toString()); }
      [^\n\r\"\\]+                   { string.append( yytext() ); }
            \\t                            { string.append('\t'); }
            \\n                            { string.append('\n'); }

            \\r                            { string.append('\r'); }
            \\\"                           { string.append('\"'); }
            \\                             { string.append('\\'); }
      }

// Set states for line and column to display errors
\n { yyline++; yycolumn = 1; yychar = 1; }


[^] { throw new Error("Caracter inesperado: " + yytext()) + " en la linea " + yyline + " y columna " + yycolumn; }


