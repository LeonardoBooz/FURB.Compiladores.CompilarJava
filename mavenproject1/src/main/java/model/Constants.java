package model;

public interface Constants extends ScannerConstants, ParserConstants
{
    int EPSILON  = 0;
    int DOLLAR   = 1;

    int t_id = 2;
    int t_cte_int = 3;
    int t_cte_float = 4;
    int t_cte_char = 5;
    int t_cte_string = 6;
    int t_TOKEN_7 = 7; //":"
    int t_TOKEN_8 = 8; //";"
    int t_TOKEN_9 = 9; //","
    int t_TOKEN_10 = 10; //"="
    int t_TOKEN_11 = 11; //"<-"
    int t_TOKEN_12 = 12; //"("
    int t_TOKEN_13 = 13; //")"
    int t_TOKEN_14 = 14; //"&&"
    int t_TOKEN_15 = 15; //"||"
    int t_TOKEN_16 = 16; //"!"
    int t_TOKEN_17 = 17; //"=="
    int t_TOKEN_18 = 18; //"!="
    int t_TOKEN_19 = 19; //"<"
    int t_TOKEN_20 = 20; //"<="
    int t_TOKEN_21 = 21; //">"
    int t_TOKEN_22 = 22; //">="
    int t_TOKEN_23 = 23; //"+"
    int t_TOKEN_24 = 24; //"-"
    int t_TOKEN_25 = 25; //"*"
    int t_TOKEN_26 = 26; //"/"
    int t_TOKEN_27 = 27; //"^"
    int t_MAIN = 28;
    int t_DEFINE = 29;
    int t_IF = 30;
    int t_ELSE = 31;
    int t_ELIF = 32;
    int t_REPEAT = 33;
    int t_WHILE = 34;
    int t_UNTIL = 35;
    int t_TELL = 36;
    int t_INT = 37;
    int t_FLOAT = 38;
    int t_CHAR = 39;
    int t_BOOL = 40;
    int t_STRING = 41;
    int t_TRUE = 42;
    int t_FALSE = 43;
    int t_END = 44;
    int t_ASK = 45;

}
