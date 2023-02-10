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

  public int getColumn() {
      return yycolumn + 1;
  }
  public int getLine() {
      return yyline + 1;
  }

  public string getText() {
      return yytext();
  }
  }
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]


/* comments */
Comment = {MultiLineComment} | {EndOfLineComment}

MultiLineComment   = "<!" [^*] ~"!>" | "<!" "!"+ ">"

// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
CommentContent       = ( [^*] | \*+ [^/*] )*

Identifier = [:jletter:] [:jletterdigit:]*

%state STRING INJEXP

%%

    /* keywords */
    <YYINITIAL> "CONJ"                {return new Symbol(sym.CONJ); }
      <YYINITIAL> "}"                 { return new Symbol(sym.RBRACE); }

      <YYINITIAL> {
      /* identifiers */
      {Identifier} { return symbol(sym.IDENTIFIER); }
      "{"  { return new Symbol(sym.LBRACE); }
      ";"  { return new Symbol(sym.SEMICOLON); }
      ":"  { return new Symbol(sys.COLON); }
      "->" {  return new Symbol(sys.ASSIGN); }
      "*" {return new Symbol(sys.TIMES); }
      "|" {return new Symbol(sys.BAR); }
      "." {return new Symbol(sys.DOT); }
      "%" {return new Symbol(sys.PERCENTAGE); }
      "+" {return new Symbol(sys.PLUS); }
      }

      /* comments*/
      {Comment} { /* ignore */ }
      {WhiteSpace} { /* ignore */ }


