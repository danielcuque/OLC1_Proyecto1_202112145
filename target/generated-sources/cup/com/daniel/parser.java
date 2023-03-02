
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.daniel;

import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import com.daniel.controller.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\041\000\002\002\004\000\002\002\005\000\002\003" +
    "\006\000\002\004\004\000\002\004\003\000\002\005\010" +
    "\000\002\006\003\000\002\006\003\000\002\007\005\000" +
    "\002\007\005\000\002\007\005\000\002\007\005\000\002" +
    "\010\004\000\002\010\003\000\002\011\005\000\002\011" +
    "\004\000\002\012\003\000\002\012\003\000\002\012\003" +
    "\000\002\012\003\000\002\015\004\000\002\015\003\000" +
    "\002\016\006\000\002\017\005\000\002\017\005\000\002" +
    "\017\004\000\002\017\004\000\002\017\004\000\002\017" +
    "\005\000\002\017\003\000\002\013\004\000\002\013\003" +
    "\000\002\014\006" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\105\000\004\005\005\001\002\000\004\002\107\001" +
    "\002\000\004\004\007\001\002\000\004\006\106\001\002" +
    "\000\004\007\052\001\002\000\006\004\007\024\ufffd\001" +
    "\002\000\004\024\013\001\002\000\006\011\uffec\024\013" +
    "\001\002\000\004\010\025\001\002\000\004\011\015\001" +
    "\002\000\004\024\017\001\002\000\004\006\uffff\001\002" +
    "\000\004\007\022\001\002\000\006\006\uffe2\024\017\001" +
    "\002\000\004\006\uffe3\001\002\000\004\026\023\001\002" +
    "\000\004\021\024\001\002\000\006\006\uffe1\024\uffe1\001" +
    "\002\000\020\005\026\012\035\013\027\014\031\015\032" +
    "\016\034\026\033\001\002\000\004\024\046\001\002\000" +
    "\020\005\026\012\035\013\027\014\031\015\032\016\034" +
    "\026\033\001\002\000\004\021\044\001\002\000\020\005" +
    "\026\012\035\013\027\014\031\015\032\016\034\026\033" +
    "\001\002\000\020\005\026\012\035\013\027\014\031\015" +
    "\032\016\034\026\033\001\002\000\022\005\uffe4\012\uffe4" +
    "\013\uffe4\014\uffe4\015\uffe4\016\uffe4\021\uffe4\026\uffe4\001" +
    "\002\000\020\005\026\012\035\013\027\014\031\015\032" +
    "\016\034\026\033\001\002\000\020\005\026\012\035\013" +
    "\027\014\031\015\032\016\034\026\033\001\002\000\020" +
    "\005\026\012\035\013\027\014\031\015\032\016\034\026" +
    "\033\001\002\000\022\005\uffe9\012\uffe9\013\uffe9\014\uffe9" +
    "\015\uffe9\016\uffe9\021\uffe9\026\uffe9\001\002\000\020\005" +
    "\026\012\035\013\027\014\031\015\032\016\034\026\033" +
    "\001\002\000\022\005\uffea\012\uffea\013\uffea\014\uffea\015" +
    "\uffea\016\uffea\021\uffea\026\uffea\001\002\000\022\005\uffe6" +
    "\012\uffe6\013\uffe6\014\uffe6\015\uffe6\016\uffe6\021\uffe6\026" +
    "\uffe6\001\002\000\022\005\uffe8\012\uffe8\013\uffe8\014\uffe8" +
    "\015\uffe8\016\uffe8\021\uffe8\026\uffe8\001\002\000\006\011" +
    "\uffeb\024\uffeb\001\002\000\022\005\uffe7\012\uffe7\013\uffe7" +
    "\014\uffe7\015\uffe7\016\uffe7\021\uffe7\026\uffe7\001\002\000" +
    "\004\006\047\001\002\000\022\005\uffe5\012\uffe5\013\uffe5" +
    "\014\uffe5\015\uffe5\016\uffe5\021\uffe5\026\uffe5\001\002\000" +
    "\004\011\uffed\001\002\000\004\024\ufffe\001\002\000\004" +
    "\024\053\001\002\000\004\010\054\001\002\000\012\022" +
    "\057\023\064\025\062\027\055\001\002\000\010\017\104" +
    "\020\uffee\021\uffee\001\002\000\006\020\074\021\ufff4\001" +
    "\002\000\010\017\072\020\ufff1\021\ufff1\001\002\000\004" +
    "\021\ufffb\001\002\000\004\021\ufffa\001\002\000\010\017" +
    "\070\020\uffef\021\uffef\001\002\000\004\021\067\001\002" +
    "\000\010\017\065\020\ufff0\021\ufff0\001\002\000\004\023" +
    "\066\001\002\000\004\021\ufff8\001\002\000\006\004\ufffc" +
    "\024\ufffc\001\002\000\004\025\071\001\002\000\004\021" +
    "\ufff7\001\002\000\004\022\073\001\002\000\004\021\ufff9" +
    "\001\002\000\012\022\100\023\101\025\102\027\076\001" +
    "\002\000\004\021\ufff5\001\002\000\006\020\uffee\021\uffee" +
    "\001\002\000\006\020\074\021\ufff2\001\002\000\006\020" +
    "\ufff1\021\ufff1\001\002\000\006\020\ufff0\021\ufff0\001\002" +
    "\000\006\020\uffef\021\uffef\001\002\000\004\021\ufff3\001" +
    "\002\000\004\027\105\001\002\000\004\021\ufff6\001\002" +
    "\000\004\002\000\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\105\000\004\002\003\001\001\000\002\001\001\000" +
    "\010\003\005\004\010\005\007\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\004\050\005\007\001\001\000" +
    "\006\015\013\016\011\001\001\000\006\015\047\016\011" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\013" +
    "\015\014\017\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\013\020\014\017\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\017\027\001\001\000\002\001\001\000\004\017\044\001" +
    "\001\000\002\001\001\000\004\017\042\001\001\000\004" +
    "\017\041\001\001\000\002\001\001\000\004\017\037\001" +
    "\001\000\004\017\035\001\001\000\004\017\036\001\001" +
    "\000\002\001\001\000\004\017\040\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\012\006\062\007\057\010\060\012\055\001" +
    "\001\000\002\001\001\000\004\011\074\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\012\076\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\011\102\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    public int operatorNodeCounter = 1;
    public int nodeCounter = 1;

    public ArrayList<Conjunto> Conjuntos = new ArrayList<Conjunto>();
    public ArrayList<Tree> Trees = new ArrayList<Tree>();
    public ArrayList<String> CheckStrings = new ArrayList<String>();


    // Lista de errores
    public ArrayList<ExceptionReport> Errors = new ArrayList<ExceptionReport>();

    public void syntax_error(Symbol s){
        Errors.add(new ExceptionReport("Sintactico", "Error de sintaxis detectado. Se detect??: " + s.value, s.left + "", s.right + ""));
        }

    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{
            System.out.println("Error sintactico irrecuperable en la L??nea " + (s.left)+ " Columna "+s.right+". Componente " + s.value + " no reconocido.");
            }
            public ArrayList<ExceptionReport> getErrores(){
                return Errors;
            }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= Begin EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // Begin ::= LBRACE BodyEntry RBRACE 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Begin",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // BodyEntry ::= ConjBody ExpBody PERCENT CheckBody 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("BodyEntry",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // ConjBody ::= ConjDef ConjBody 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ConjBody",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // ConjBody ::= ConjDef 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ConjBody",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // ConjDef ::= CONJ COLON IDENTIFIER ARROW ConjNotation SEMICOLON 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ConjDef",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // ConjNotation ::= RangeExp 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ConjNotation",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // ConjNotation ::= IndExp 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ConjNotation",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // RangeExp ::= LOWERCASE TILDE LOWERCASE 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("RangeExp",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // RangeExp ::= UPPERCASE TILDE UPPERCASE 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("RangeExp",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // RangeExp ::= DIGIT TILDE DIGIT 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("RangeExp",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // RangeExp ::= ASCII TILDE ASCII 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("RangeExp",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // IndExp ::= UnitSymbol MoreIndExp 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("IndExp",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // IndExp ::= UnitSymbol 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("IndExp",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // MoreIndExp ::= COMMA UnitSymbol MoreIndExp 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("MoreIndExp",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // MoreIndExp ::= COMMA UnitSymbol 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("MoreIndExp",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // UnitSymbol ::= LOWERCASE 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("UnitSymbol",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // UnitSymbol ::= UPPERCASE 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("UnitSymbol",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // UnitSymbol ::= DIGIT 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("UnitSymbol",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // UnitSymbol ::= ASCII 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("UnitSymbol",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // ExpBody ::= ExpLine ExpBody 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ExpBody",11, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // ExpBody ::= ExpLine 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ExpBody",11, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // ExpLine ::= IDENTIFIER ARROW RegExp SEMICOLON 
            {
              Object RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node val = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
    Trees.add(new Tree(val, id));

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ExpLine",12, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // RegExp ::= PIPE RegExp RegExp 
            {
              Node RESULT =null;
		int pipe1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int pipe1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node pipe1 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int pipe2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int pipe2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node pipe2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
    Node node = new Node("|",NodeType.OR, operatorNodeCounter,pipe1, pipe2);
    operatorNodeCounter++;
    RESULT = node;


              CUP$parser$result = parser.getSymbolFactory().newSymbol("RegExp",13, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // RegExp ::= DOT RegExp RegExp 
            {
              Node RESULT =null;
		int dot1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int dot1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node dot1 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int dot2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int dot2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node dot2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
Node node = new Node(".",NodeType.AND, operatorNodeCounter,dot1, dot2);
operatorNodeCounter++;
RESULT = node;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("RegExp",13, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // RegExp ::= PLUS RegExp 
            {
              Node RESULT =null;
		int plusleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int plusright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node plus = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
Node node = new Node("+",NodeType.PLUS, operatorNodeCounter,plus);
operatorNodeCounter++;
RESULT = node;


              CUP$parser$result = parser.getSymbolFactory().newSymbol("RegExp",13, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // RegExp ::= STAR RegExp 
            {
              Node RESULT =null;
		int starleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int starright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node star = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
Node node = new Node("*",NodeType.STAR, operatorNodeCounter,star);
operatorNodeCounter++;
RESULT = node;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("RegExp",13, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // RegExp ::= QUERY RegExp 
            {
              Node RESULT =null;
		int queryleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int queryright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node query = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
Node node = new Node("?",NodeType.QUERY, operatorNodeCounter,query);
operatorNodeCounter++;
RESULT = node;


              CUP$parser$result = parser.getSymbolFactory().newSymbol("RegExp",13, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // RegExp ::= LBRACE IDENTIFIER RBRACE 
            {
              Node RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
Node node = new Node(id, NodeType.LEAVE, nodeCounter);
nodeCounter++;
RESULT = node;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("RegExp",13, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // RegExp ::= STRING_LITERAL 
            {
              Node RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int valright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String val = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
Node node = new Node(val, NodeType.LEAVE, nodeCounter);
nodeCounter++;
RESULT = node;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("RegExp",13, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // CheckBody ::= CheckLine CheckBody 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("CheckBody",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // CheckBody ::= CheckLine 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("CheckBody",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // CheckLine ::= IDENTIFIER COLON STRING_LITERAL SEMICOLON 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("CheckLine",10, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
