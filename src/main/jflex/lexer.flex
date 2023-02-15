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
ASCII = [\x20-\x2F\x3A-\x40\x5B-\x60\x7B-\x7E]


// Comments
Comment = {MultiLineComment} | {EndOfLineComment}

// MultiLineComment can be the last line of the file, without line terminator.
MultiLineComment   = "<!" [^*] ~"!>" | "<!" "!"+ ">"

// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?

Identifier = [:jletter:] [:jletterdigit:]*

lowercase = [a-z]
uppercase = [A-Z]
digit = [0-9]

Arrow = "->"


%state CONJUNTO
%state NOTATION

// General
%state CHARLITERAL
%state STRING


// Intermediate state for set regex or declarate regex
%state INTER_STATE_REGEX

// Get Literals of regex
%state STRING_REGEX
%state CHARLITERAL_REGEX


// Declare a regex
%state REGEX

//Represent a conjunt
%state REGEX_REPRESENTATION

// Set a string to analize
%state REGEX_STATEMENT

// Strings and characters
%state STRING_REGEX_STATEMENT
%state CHARLITERAL_REGEX_STATEMENT

%%



    // Keywords
     <YYINITIAL> "CONJ" {
          yybegin(CONJUNTO);
          return symbol(sym.CONJ);
      }

      <YYINITIAL> {

        // Identifiers
        {Identifier} {
          yybegin(INTER_STATE_REGEX);
          return symbol(sym.IDENTIFIER, yytext()); }

      // Literals
        \" {
          stringBuffer.setLength(0);
          yybegin(STRING);
      }


      \' {
          yybegin(CHARLITERAL);
          return symbol(sym.CHAR_LITERAL, stringBuffer.toString());
        }
      }

      <CONJUNTO> {
      ":" {
          return symbol(sym.COLON, yytext());
      }
      {Identifier} { return symbol(sym.IDENTIFIER, yytext()); }
      {Arrow} {
          yybegin(NOTATION);
          return symbol(sym.ARROW);
        }
      }

      <NOTATION> {
        {lowercase} { return symbol(sym.LOWERCASE, yytext()); }
        {uppercase} { return symbol(sym.UPPERCASE, yytext()); }
        {digit} { return symbol(sym.DIGIT, yytext()); }
        "~" { return symbol(sym.TILDE, yytext()); }
        "," { return symbol(sym.COMMA, yytext()); }
      ";" {
                yybegin(YYINITIAL);
                return symbol(sym.SEMICOLON);
            }
        {ASCII} { return symbol(sym.ASCII, yytext()); }
      }

      <INTER_STATE_REGEX> {
        {Arrow} {
          yybegin(REGEX);
          return symbol(sym.ARROW);
        }

        ":" {
          yybegin(REGEX_STATEMENT);
            return symbol(sym.COLON);
      }
      }

      <REGEX> {
      "." { return symbol(sym.DOT); }
      "*" { return symbol(sym.STAR); }
      "+" { return symbol(sym.PLUS); }
        "?" { return symbol(sym.QUERY); }
        "|" { return symbol(sym.PIPE); }
      \" {
          stringBuffer.setLength(0);
          yybegin(STRING_REGEX);}
        \' {
          stringBuffer.setLength(0);
          yybegin(CHARLITERAL_REGEX);}

      "{" {
          yybegin(REGEX_REPRESENTATION);
          return symbol(sym.LBRACE); }

          ";" {
                yybegin(YYINITIAL);
                return symbol(sym.SEMICOLON);
            }
      }

      <REGEX_REPRESENTATION> {
      {Identifier} { return symbol(sym.IDENTIFIER, yytext()); }
      "}" {
          yybegin(REGEX);
          return symbol(sym.RBRACE); }
      }
      <STRING_REGEX> {
             \" { yybegin(REGEX); return symbol(sym.STRING_LITERAL, stringBuffer.toString()); }
            [^\n\r\"\\]+                   { string.append( yytext() ); }
                  \\t                            { string.append('\t'); }
                  \\n                            { string.append('\n'); }

                  \\r                            { string.append('\r'); }
                  \\\"                           { string.append('\"'); }
                  \\                             { string.append('\\'); }
            }

     <CHARLITERAL_REGEX> {
        \' { yybegin(REGEX); return symbol(sym.CHAR_LITERAL, stringBuffer.toString()); }
     [^\n\r\'\\]+                   { string.append( yytext() ); }
            \\t                            { string.append('\t'); }
            \\n                            { string.append('\n'); }

            \\r                            { string.append('\r'); }
            \\\"                           { string.append('\"'); }
            \\                             { string.append('\\'); }
      }



    <REGEX_STATEMENT> {
    {Identifier} { return symbol(sym.IDENTIFIER, yytext()); }
    ":" {
      yybegin(YYINITIAL);
        return symbol(sym.COLON);

    }
    \" {
        stringBuffer.setLength(0);
        yybegin(STRING_REGEX_STATEMENT);
      }
        \' {
            stringBuffer.setLength(0);
            yybegin(CHARLITERAL_REGEX_STATEMENT);
        }

    ";" {
        yybegin(YYINITIAL);
          return symbol(sym.SEMICOLON);}
    }

    <STRING_REGEX_STATEMENT> {
           \" { yybegin(REGEX_STATEMENT); return symbol(sym.STRING_LITERAL, stringBuffer.toString()); }
          [^\n\r\"\\]+                   { string.append( yytext() ); }
                \\t                            { string.append('\t'); }
                \\n                            { string.append('\n'); }

                \\r                            { string.append('\r'); }
                \\\"                           { string.append('\"'); }
                \\                             { string.append('\\'); }
          }

    <CHARLITERAL_REGEX_STATEMENT> {
        \' { yybegin(REGEX_STATEMENT); return symbol(sym.CHAR_LITERAL, stringBuffer.toString()); }
        [^\n\r\'\\]+                   { string.append( yytext() ); }
                \\t                            { string.append('\t'); }
                \\n                            { string.append('\n'); }

                \\r                            { string.append('\r'); }
                \\\"                           { string.append('\"'); }
                \\                             { string.append('\\'); }
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

      <CHARLITERAL> {
        \' { yybegin(YYINITIAL); return symbol(sym.CHAR_LITERAL, stringBuffer.toString()); }
      [^\n\r\'\\]+                   { string.append( yytext() ); }
            \\t                            { string.append('\t'); }
            \\n                            { string.append('\n'); }

            \\r                            { string.append('\r'); }
            \\\"                           { string.append('\"'); }
            \\                             { string.append('\\'); }
      }

// Set states for line and column to display errors
\n { yyline++; yycolumn = 1; yychar = 1; return symbol(sym.NEWLINE); }

          // Separators
          "{" { return symbol(sym.LBRACE); }
          "}" { return symbol(sym.RBRACE); }
          ":" { return symbol(sym.COLON); }
          "%%" { return symbol(sym.PERCENT); }
          "."  {  return symbol(sym.DOT); }
          "*" {  return symbol(sym.STAR); }
          "+" {  return symbol(sym.PLUS); }
          "?" {  return symbol(sym.QUERY); }
          "|" {  return symbol(sym.PIPE); }
          "&" {  return symbol(sym.AMPERSAND); }

      // Comments
      {Comment} { /* ignore */ }

      // White space
      {WhiteSpace} { /* ignore */ }




[^] { throw new Error("Caracter inesperado: " + yytext()) + " en la linea " + yyline + " y columna " + yycolumn; }


