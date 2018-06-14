package com.fema.compilador.lexico;

%%

%{

public String resposta = "";
public String palavra = "";

private String imprimir(String descricao, String lexema) {
    System.out.println(lexema + " - " + descricao);
    String textoResposta = lexema + " - " + descricao;
    return textoResposta + "\n";
}

private void imprimirError(String lexema) {
	System.out.println(lexema);
	palavra += lexema;
}

%}


%class LexicalAnalyzer
%type String


BRANCO = [\n|\v|\t|\r|\f| ]
ID = #[a-z|A-Z][a-z|A-Z|0-9]*
SOMA = "+"
SUBTRACAO = "-"
MULTIPLICACAO = "*"
DIVISAO = "&"
INTEIRO = 0|[1-9][0-9]*
BOOLEAN = true|false
ABRE = [/|\\]
DECLA = #
STRING = \"[a-z|A-Z|0-9]*\"


%%

"fdp"						{ resposta += imprimir("Palavra reservada fdp", yytext()); }
"pdf"						{ resposta += imprimir("Palavra reservada pdf", yytext()); }
"vsf"						{ resposta += imprimir("Palavra reservada vsf", yytext()); }
"tnc"						{ resposta += imprimir("Palavra reservada tnc", yytext()); }
"fdentro"					{ resposta += imprimir("Palavra reservada fdentro", yytext()); }
"fsai"						{ resposta += imprimir("Palavra reservada fsai", yytext()); }
"pqp"						{ resposta += imprimir("Palavra reservada pqp", yytext()); }
{BRANCO}                    { resposta += imprimir("Espaço em branco", yytext()); }
{ID}                        { resposta += imprimir("Variavel", yytext()); }
{SOMA}                      { resposta += imprimir("Operador de soma", yytext()); }
{SUBTRACAO}					{ resposta += imprimir("Operador de subtração", yytext()); }
{MULTIPLICACAO}				{ resposta += imprimir("Operador de multiplicação", yytext()); }
{DIVISAO}					{ resposta += imprimir("Operador de divisão", yytext()); }
{INTEIRO}                   { resposta += imprimir("Número Inteiro", yytext()); }
{BOOLEAN}					{ resposta += imprimir("Boolean", yytext()); }
{ABRE}                      { resposta += imprimir("Caracter Especial", yytext()); }
{DECLA}						{ resposta += imprimir("Declaração de Variavel", yytext()); }
{STRING}					{ resposta += imprimir("Sequencia de Caracter", yytext()); }
">"							{ resposta += imprimir("Operador Lógico de maior que", yytext()); }	
"<"							{ resposta += imprimir("Operador Lógico de menor que", yytext()); }
"="							{ resposta += imprimir("Operador Lógico de igual", yytext()); }
"=!"						{ resposta += imprimir("Operador Lógico de diferente", yytext()); }
"and"						{ resposta += imprimir("Operador Lógico de 'e'", yytext()); }
"or"						{ resposta += imprimir("Operador Lógico de 'ou'", yytext()); }
"("							{ resposta += imprimir("Caracter Especial", yytext()); }
")"							{ resposta += imprimir("Caracter Especial", yytext()); }
";"							{ resposta += imprimir("Caracter Especial", yytext()); }


. { throw new RuntimeException("Caractere inválido " + yytext()); }