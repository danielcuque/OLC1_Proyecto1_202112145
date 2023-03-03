package com.daniel;

import com.daniel.controller.ExceptionReport;
import java_cup.runtime.*;
import java.util.ArrayList;

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

   public ArrayList<ExceptionReport> errors = new ArrayList();

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
ASCII = [\x20-\x2F\x3A-\x40\x5B-\x60\x7B-\x7E]


// Comments
Comment = {MultiLineComment} | {EndOfLineComment}

// MultiLineComment can be the last line of the file, without line terminator.
MultiLineComment   = "<!" [^*] ~"!>" | "<!" "!"+ ">"

// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?

Identifier = [a-zA-Z_]+[a-zA-Z0-9_]*
Lowercase = [a-z]{1}
Uppercase = [A-Z]{1}
Digit = [0-9]+
Backslash = "\\"
DoubleQuote = "\""
SingleQuote = "'"
EscapeSequence = {Backslash} {SingleQuote} | {Backslash} {DoubleQuote} | {Backslash} {Backslash}
Conj = "CONJ"
Lbrace = "{"
Rbrace = "}"
Colon = ":"
Arrow = "->"
Percent = "%%"
Dot = "."
Star = "*"
Plus = "+"
Query = "?"
Pipe = "|"
Tilde = "~"
Comma = ","
Semicolon = ";"

%state STRING

%%
      <YYINITIAL> {Comment} { /* Ignore */ }
      <YYINITIAL> {WhiteSpace} { /* Ignore */ }
      <YYINITIAL> {Conj} { return symbol(sym.CONJ, yytext()); }
      <YYINITIAL> {Lbrace} { return symbol(sym.LBRACE, yytext()); }
      <YYINITIAL> {Rbrace} { return symbol(sym.RBRACE, yytext()); }
      <YYINITIAL> {Colon} { return symbol(sym.COLON, yytext()); }
      <YYINITIAL> {Arrow} { return symbol(sym.ARROW, yytext()); }
      <YYINITIAL> {Percent} { return symbol(sym.PERCENT, yytext()); }
      <YYINITIAL> {Dot} { return symbol(sym.DOT, yytext()); }
      <YYINITIAL> {Star} { return symbol(sym.STAR, yytext()); }
      <YYINITIAL> {Plus} { return symbol(sym.PLUS, yytext()); }
      <YYINITIAL> {Query} { return symbol(sym.QUERY, yytext()); }
      <YYINITIAL> {Pipe} { return symbol(sym.PIPE, yytext()); }
      <YYINITIAL> {Tilde} { return symbol(sym.TILDE, yytext()); }
      <YYINITIAL> {Comma} { return symbol(sym.COMMA, yytext()); }
      <YYINITIAL> {Semicolon} { return symbol(sym.SEMICOLON, yytext()); }
      <YYINITIAL> {EscapeSequence} { return symbol(sym.ESCAPE_SEQUENCE, yytext()); }
      <YYINITIAL> \" { stringBuffer.setLength(0); yybegin(STRING);}
      <YYINITIAL> {Lowercase} { return symbol(sym.LOWERCASE, yytext()); }
      <YYINITIAL> {Uppercase} { return symbol(sym.UPPERCASE, yytext()); }
      <YYINITIAL> {Identifier} { return symbol(sym.IDENTIFIER, yytext()); }
      <YYINITIAL> {Digit} { return symbol(sym.DIGIT, yytext()); }
      <YYINITIAL> {ASCII} { return symbol(sym.ASCII, yytext()); }

      <STRING> {
      \"                             { yybegin(YYINITIAL);
                                             return symbol(sym.STRING_LITERAL,
                                             stringBuffer.toString()); }
            [^\n\r\"\\]+                   { stringBuffer.append( yytext() ); }
            \\t                            { stringBuffer.append('\t'); }
            \\n                            { stringBuffer.append('\n'); }

            \\r                            { stringBuffer.append('\r'); }
            \\\"                           { stringBuffer.append('\"'); }
            \\                             { stringBuffer.append('\\'); }
      }



[^] {
          errors.add(new ExceptionReport(
                  "Lexico",
                  "Caracter inesperado:" + yytext() + " en la linea " + yyline + " y columna " + yycolumn,
                  yyline+"", yycolumn+""));
      }