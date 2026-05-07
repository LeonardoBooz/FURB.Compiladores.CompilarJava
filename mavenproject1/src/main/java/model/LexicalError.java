package model;

public class LexicalError extends AnalysisError
{
    private char simbolo;
    public LexicalError(String msg, int position)
	 {
        super(msg, position);
    }

    public LexicalError(String msg)
    {
        super(msg);
    }
    

    public LexicalError(String msg, int position, char simbolo) {
        super(msg, position);
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }
}