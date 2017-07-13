#include<stdio.h>
#include<conio.h>
#include<windows.h>
#include<time.h>
#include<stdlib.h>
int score;
void gotoxy (int x, int y)
{
 COORD c = { x, y };
 SetConsoleCursorPosition( GetStdHandle(STD_OUTPUT_HANDLE) , c);
}
void setcolor(int fg,int bg)
{
HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
SetConsoleTextAttribute(hConsole, bg*16+fg);
}
void draw_tree (int x,int y)
{    if(y==22){
     gotoxy(x,y);   setcolor(4,4); printf(" * ");
     gotoxy(x,y+1); setcolor(0,0); printf("***");
     gotoxy(x,y+2); setcolor(0,0);printf(" "); setcolor(0,0); printf("|"); setcolor(0,0);printf(" ");    }
     if(y==21){
     gotoxy(x,y+3); setcolor(0,0); printf("   ");
     gotoxy(x,y);   setcolor(2,2); printf(" * ");
     gotoxy(x,y+1); setcolor(4,4); printf("***");
     gotoxy(x,y+2); setcolor(0,0);printf(" "); setcolor(0,0); printf("|"); setcolor(0,0);printf(" ");
     }
     if(y==20){
     gotoxy(x,y+3); setcolor(0,0); printf("   ");
     gotoxy(x,y);   setcolor(2,2); printf(" * ");
     gotoxy(x,y+1); setcolor(2,2); printf("***");
     gotoxy(x,y+2); setcolor(4,4);printf(" "); setcolor(4,4); printf("|"); setcolor(4,4);printf(" ");
     }
     if(y<20){
         if(y==19){
     gotoxy(x,y+3); setcolor(4,4); printf("   ");
     setcolor(11,11);}
     gotoxy(x,y);   setcolor(2,2); printf(" * ");
     gotoxy(x,y+1); setcolor(2,2); printf("***");
     gotoxy(x,y+2); setcolor(11,11);printf(" "); setcolor(15,15); printf("|"); setcolor(11,11);printf(" ");
     }
}
void erase_tree (int x,int y)
{       if(y>19){
     if(y==22){
     gotoxy(x,y);   setcolor(4,4); printf(" * ");
     gotoxy(x,y+1); setcolor(0,0); printf("***");
     gotoxy(x,y+2); setcolor(0,0);printf(" "); setcolor(0,0); printf("|"); setcolor(0,0);printf(" ");    }
     if(y==21){
     gotoxy(x,y+3); setcolor(0,0); printf("   ");
     gotoxy(x,y);   setcolor(2,2); printf(" * ");
     gotoxy(x,y+1); setcolor(4,4); printf("***");
     gotoxy(x,y+2); setcolor(0,0);printf(" "); setcolor(0,0); printf("|"); setcolor(0,0);printf(" ");
     }
     if(y==20){
     gotoxy(x,y+3); setcolor(0,0); printf("   ");
     gotoxy(x,y);   setcolor(2,2); printf(" * ");
     gotoxy(x,y+1); setcolor(2,2); printf("***");
     gotoxy(x,y+2); setcolor(4,4);printf(" "); setcolor(4,4); printf("|"); setcolor(4,4);printf(" ");
     }
       }
       else{
       gotoxy(x,y+2); setcolor(11,11);printf("   ");
       gotoxy(x,y+1); setcolor(11,11);printf(" "); setcolor(15,15); printf("|"); setcolor(11,11);printf(" ");
       }
        if(y==4){
            gotoxy(x,y); setcolor(11,11);printf("   ");
            gotoxy(x,y+1); setcolor(11,11);printf("   ");
            gotoxy(x,y+2); setcolor(11,11);printf("   ");
        }
}
void erase_end (int x,int y)
{
            gotoxy(x,y+1); setcolor(11,11);printf("   ");
            gotoxy(x,y); setcolor(11,11);printf("   ");
            gotoxy(x,y-1); setcolor(11,11);printf("   ");

}
void MP ()
{
char map[20][80]={{"*******************************************************************************\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*                                                                             *\n"},
                  {"*******************************************************************************\n"}};

int i,j;
    for(i=0;i<20;i++){
        for(j=0;j<80;j++){
            if(map[i][j]=='*'){
            setcolor(4,4);
            gotoxy(20+j,3+i);printf("%c",map[i][j]);
            }
            else{
            setcolor(11,11);
            printf("%c",map[i][j]);
        }
        }
        setcolor(0,1);
    }
}
int drawski(int x,int y)
{
	gotoxy(x,y);
	setcolor(12,11);printf("%c%c%c",169,514,170);
}
int erase(int x,int y)
{
	gotoxy(x,y);
	setcolor(0,11);
	printf("   ");
}
char cursor(int x, int y){

HANDLE hStd = GetStdHandle(STD_OUTPUT_HANDLE);

char buf[2]; COORD c = {x,y}; DWORD num_read;

if(

!ReadConsoleOutputCharacter(hStd,(LPTSTR)buf,1,c,(LPDWORD)&num_read)

)

return '\0';

else

return buf[0];

}
void setcursor(int visible)////////////del cursor
{
HANDLE console = GetStdHandle(STD_OUTPUT_HANDLE);
CONSOLE_CURSOR_INFO lpCursor;
lpCursor.bVisible = visible;
lpCursor.dwSize = 20;
SetConsoleCursorInfo(console,&lpCursor);
}
int stone (int x,int y){
setcolor(10,0);
gotoxy(x,y);printf("%c%c",176,176);
gotoxy(x-1,y+1);printf("%c%c%c%c",176,177,177,178);
gotoxy(x-2,y+2);printf("%c%c%c%c%c%c",176,177,177,178,178,178);
gotoxy(x-3,y+3);printf("%c%c%c%c%c%c%c%c",176,177,177,178,178,178,178,178);
gotoxy(x-2,y+4);printf("%c%c%c%c%c%c",176,177,177,178,178,178);
gotoxy(x-1,y+5);printf("%c%c%c%c",176,177,177,178);
gotoxy(x,y+6);printf("%c%c",176,177);
}
int erase_stone (int x,int y){
    setcolor(0,0);
gotoxy(x,y);printf(" ");
gotoxy(x-1,y+1);printf(" ");
gotoxy(x-2,y+2);printf(" ");
gotoxy(x-3,y+3);printf(" ");
gotoxy(x-2,y+4);printf(" ");
gotoxy(x-1,y+5);printf(" ");
gotoxy(x,y+6);printf(" ");

}
int erase_stone_end (int x,int y){
    setcolor(0,0);
gotoxy(x,y);printf("   ");
gotoxy(x-1,y+1);printf("    ");
gotoxy(x-2,y+2);printf("      ");
gotoxy(x-3,y+3);printf("        ");
gotoxy(x-2,y+4);printf("      ");
gotoxy(x-1,y+5);printf("    ");
gotoxy(x,y+6);printf("  ");

}
int bird (int x,int y){
setcolor(6,0);gotoxy(x,y);printf("__ \\---/ __");
gotoxy(x,y+1);printf("\\_\\_\\_/_/_/");
gotoxy(x+2,y+2);printf("\\__ __/");
gotoxy(x+4,y+3);printf("( )");
gotoxy(x+5,y+4);setcolor(14,0);printf("%c",287);
setcolor(0,0);

}
int erase_bird_end (int x,int y){
gotoxy(x,y);printf("           ");
gotoxy(x,y+1);printf("           ");
gotoxy(x+2,y+2);printf("       ");
gotoxy(x+4,y+3);printf("   ");
gotoxy(x+5,y+4);printf(" ");
}
int erase_bird (int x,int y){
gotoxy(x,y);printf("           ");
}
int man (int x,int y){
setcolor(11,0);gotoxy(x,y);printf("<(===)");setcolor(15,0);
gotoxy(x+1,y+1);printf("o  /");
gotoxy(x,y+2);printf("/__/|");
gotoxy(x+1,y+3);printf("\\/-|");
gotoxy(x+1,y+4);printf("/|||\\");
}
int erase_man (int x,int y){
    setcolor(0,0);
gotoxy(x,y);printf("      ");
gotoxy(x+1,y+1);printf("    ");
gotoxy(x,y+2);printf("     ");
gotoxy(x+1,y+3);printf("    ");
gotoxy(x+1,y+4);printf("     ");

}

int minimap (int *score_n){
SetConsoleCP(437);
SetConsoleOutputCP(437);
system("MODE 123,30");
 srand( time( NULL ) );
int i,j;
    for(i=0;i<50;i++){
        for(j=0;j<20;j++){
            {setcolor(0,i);printf("error ");}
        }
        if(i==49){setcolor(0,0);system("CLS");}
    }
////////////////////////int rand //////////////////////////////////
 int x_t=rand()%80+1;
 int y_t=rand()%22+1;
 int a_b=rand()%20+1;
 int b_b=rand()%22+1;

int x2_t=rand()%100+5;
int y2_t=rand()%5+1;
int a2_b=rand()%100+5;
int b2_b=rand()%15+1;
int p_x=25;
int p_y=13;
char ch;
int x=80,y=20,direction=99;
int jump=21;
int add=1;
int time=0;
int count=2,slp_count=50;

///////////////////////////////////////////////////////////////////
if((x_t!=a_b-3||a_b-2||a_b-1||a_b)&&(y_t!=b_b||b_b+1||b_b+2||b_b+3||b_b+4||b_b+5||b_b+6)){
for(;x_t<=115;add++){
if(direction==99)man(x,y);
{
    gotoxy(p_x,p_y);setcolor(11,17);printf("#");setcolor(0,0);
if((x==p_x||x+1==p_x||x+2==p_x||x+3==p_x||x+4==p_x||x+5==p_x)&&y==p_y){
        p_x=rand()%100+5;
        p_y=rand()%20+1;
        jump++;
}
if(*score_n>5000){count=1;slp_count=30;}
if(time==0){
/*if((x==x_t||x==x_t-1||x==x_t-2||x==x_t-3||x==x_t-4||x==x_t+1||x==x_t+2||x==x_t+3)&&(y==y_t||y==y_t+1||y==y_t+2||y==y_t+3||y==y_t+4||y==y_t+5||y==y_t+6))break;*/
if((x==x_t&&y==y_t)||(x==x_t+3&&y==y_t+3)||(x==x_t&&y==y_t+6)||(x==x_t+1&&y==y_t+1)||(x==x_t+2&&y==y_t+2)||(x==x_t+2&&y==y_t+4)||(x==x_t+1&&y==y_t+5)||(x==x_t-1&&y==y_t)||(x==x_t-2&&y==y_t+1)||(x==x_t-3&&y==y_t+2)||(x==x_t-4&&y==y_t+3)||(x==x_t-3&&y==y_t+4)||(x==x_t-2&&y==y_t+5)||(x==x_t-1&&y==y_t+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+1==x_t&&y==y_t)||(x+1==x_t+3&&y==y_t+3)||(x+1==x_t&&y==y_t+6)||(x+1==x_t+1&&y==y_t+1)||(x+1==x_t+2&&y==y_t+2)||(x+1==x_t+2&&y==y_t+4)||(x+1==x_t+1&&y==y_t+5)||(x+1==x_t-1&&y==y_t)||(x+1==x_t-2&&y==y_t+1)||(x+1==x_t-3&&y==y_t+2)||(x+1==x_t-4&&y==y_t+3)||(x+1==x_t-3&&y==y_t+4)||(x+1==x_t-2&&y==y_t+5)||(x+1==x_t-1&&y==y_t+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+2==x_t&&y==y_t)||(x+2==x_t+3&&y==y_t+3)||(x+2==x_t&&y==y_t+6)||(x+2==x_t+1&&y==y_t+1)||(x+2==x_t+2&&y==y_t+2)||(x+2==x_t+2&&y==y_t+4)||(x+2==x_t+1&&y==y_t+5)||(x+2==x_t-1&&y==y_t)||(x+2==x_t-2&&y==y_t+1)||(x+2==x_t-3&&y==y_t+2)||(x+2==x_t-4&&y==y_t+3)||(x+2==x_t-3&&y==y_t+4)||(x+2==x_t-2&&y==y_t+5)||(x+2==x_t-1&&y==y_t+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+3==x_t&&y==y_t)||(x+3==x_t+3&&y==y_t+3)||(x+3==x_t&&y==y_t+6)||(x+3==x_t+1&&y==y_t+1)||(x+3==x_t+2&&y==y_t+2)||(x+3==x_t+2&&y==y_t+4)||(x+3==x_t+1&&y==y_t+5)||(x+3==x_t-1&&y==y_t)||(x+3==x_t-2&&y==y_t+1)||(x+3==x_t-3&&y==y_t+2)||(x+3==x_t-4&&y==y_t+3)||(x+3==x_t-3&&y==y_t+4)||(x+3==x_t-2&&y==y_t+5)||(x+3==x_t-1&&y==y_t+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+4==x_t&&y==y_t)||(x+4==x_t+3&&y==y_t+3)||(x+4==x_t&&y==y_t+6)||(x+4==x_t+1&&y==y_t+1)||(x+4==x_t+2&&y==y_t+2)||(x+4==x_t+2&&y==y_t+4)||(x+4==x_t+1&&y==y_t+5)||(x+4==x_t-1&&y==y_t)||(x+4==x_t-2&&y==y_t+1)||(x+4==x_t-3&&y==y_t+2)||(x+4==x_t-4&&y==y_t+3)||(x+4==x_t-3&&y==y_t+4)||(x+4==x_t-2&&y==y_t+5)||(x+4==x_t-1&&y==y_t+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+5==x_t&&y==y_t)||(x+5==x_t+3&&y==y_t+3)||(x+5==x_t&&y==y_t+6)||(x+5==x_t+1&&y==y_t+1)||(x+5==x_t+2&&y==y_t+2)||(x+5==x_t+2&&y==y_t+4)||(x+5==x_t+1&&y==y_t+5)||(x+5==x_t-1&&y==y_t)||(x+5==x_t-2&&y==y_t+1)||(x+5==x_t-3&&y==y_t+2)||(x+5==x_t-4&&y==y_t+3)||(x+5==x_t-3&&y==y_t+4)||(x+5==x_t-2&&y==y_t+5)||(x+5==x_t-1&&y==y_t+6)){system("CLS");setcolor(0,0);MP();break;}
//////////////////////////
if((x+1==x_t&&y+1==y_t)||(x+1==x_t+3&&y+1==y_t+3)||(x+1==x_t&&y+1==y_t+6)||(x+1==x_t+1&&y+1==y_t+1)||(x+1==x_t+2&&y+1==y_t+2)||(x+1==x_t+2&&y+1==y_t+4)||(x+1==x_t+1&&y+1==y_t+5)||(x+1==x_t-1&&y+1==y_t)||(x+1==x_t-2&&y+1==y_t+1)||(x+1==x_t-3&&y+1==y_t+2)||(x+1==x_t-4&&y+1==y_t+3)||(x+1==x_t-3&&y+1==y_t+4)||(x+1==x_t-2&&y+1==y_t+5)||(x+1==x_t-1&&y+1==y_t+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+4==x_t&&y+1==y_t)||(x+4==x_t+3&&y+1==y_t+3)||(x+4==x_t&&y+1==y_t+6)||(x+4==x_t+1&&y+1==y_t+1)||(x+4==x_t+2&&y+1==y_t+2)||(x+4==x_t+2&&y+1==y_t+4)||(x+4==x_t+1&&y+1==y_t+5)||(x+4==x_t-1&&y+1==y_t)||(x+4==x_t-2&&y+1==y_t+1)||(x+4==x_t-3&&y+1==y_t+2)||(x+4==x_t-4&&y+1==y_t+3)||(x+4==x_t-3&&y+1==y_t+4)||(x+4==x_t-2&&y+1==y_t+5)||(x+4==x_t-1&&y+1==y_t+6)){system("CLS");setcolor(0,0);MP();break;}
if((x==x_t&&y+2==y_t)||(x==x_t+3&&y+2==y_t+3)||(x==x_t&&y+2==y_t+6)||(x==x_t+1&&y+2==y_t+1)||(x==x_t+2&&y+2==y_t+2)||(x==x_t+2&&y+2==y_t+4)||(x==x_t+1&&y+2==y_t+5)||(x==x_t-1&&y+2==y_t)||(x==x_t-2&&y+2==y_t+1)||(x==x_t-3&&y+2==y_t+2)||(x==x_t-4&&y+2==y_t+3)||(x==x_t-3&&y+2==y_t+4)||(x==x_t-2&&y+2==y_t+5)||(x==x_t-1&&y+2==y_t+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+4==x_t&&y+2==y_t)||(x+4==x_t+3&&y+2==y_t+3)||(x+4==x_t&&y+2==y_t+6)||(x+4==x_t+1&&y+2==y_t+1)||(x+4==x_t+2&&y+2==y_t+2)||(x+4==x_t+2&&y+2==y_t+4)||(x+4==x_t+1&&y+2==y_t+5)||(x+4==x_t-1&&y+2==y_t)||(x+4==x_t-2&&y+2==y_t+1)||(x+4==x_t-3&&y+2==y_t+2)||(x+4==x_t-4&&y+2==y_t+3)||(x+4==x_t-3&&y+2==y_t+4)||(x+4==x_t-2&&y+2==y_t+5)||(x+4==x_t-1&&y+2==y_t+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+1==x_t&&y+3==y_t)||(x+1==x_t+3&&y+3==y_t+3)||(x+1==x_t&&y+3==y_t+6)||(x+1==x_t+1&&y+3==y_t+1)||(x+1==x_t+2&&y+3==y_t+2)||(x+1==x_t+2&&y+3==y_t+4)||(x+1==x_t+1&&y+3==y_t+5)||(x+1==x_t-1&&y+3==y_t)||(x+1==x_t-2&&y+3==y_t+1)||(x+1==x_t-3&&y+3==y_t+2)||(x+1==x_t-4&&y+3==y_t+3)||(x+1==x_t-3&&y+3==y_t+4)||(x+1==x_t-2&&y+3==y_t+5)||(x+1==x_t-1&&y+3==y_t+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+4==x_t&&y+3==y_t)||(x+4==x_t+3&&y+3==y_t+3)||(x+4==x_t&&y+3==y_t+6)||(x+4==x_t+1&&y+3==y_t+1)||(x+4==x_t+2&&y+3==y_t+2)||(x+4==x_t+2&&y+3==y_t+4)||(x+4==x_t+1&&y+3==y_t+5)||(x+4==x_t-1&&y+3==y_t)||(x+4==x_t-2&&y+3==y_t+1)||(x+4==x_t-3&&y+3==y_t+2)||(x+4==x_t-4&&y+3==y_t+3)||(x+4==x_t-3&&y+3==y_t+4)||(x+4==x_t-2&&y+3==y_t+5)||(x+4==x_t-1&&y+3==y_t+6)){system("CLS");setcolor(0,0);MP();break;}

if((x+1==x_t&&y+4==y_t)||(x+1==x_t+3&&y+4==y_t+3)||(x+1==x_t&&y+4==y_t+6)||(x+1==x_t+1&&y+4==y_t+1)||(x+1==x_t+2&&y+4==y_t+2)||(x+1==x_t+2&&y+4==y_t+4)||(x+1==x_t+1&&y+4==y_t+5)||(x+1==x_t-1&&y+4==y_t)||(x+1==x_t-2&&y+4==y_t+1)||(x+1==x_t-3&&y+4==y_t+2)||(x+1==x_t-4&&y+4==y_t+3)||(x+1==x_t-3&&y+4==y_t+4)||(x+1==x_t-2&&y+4==y_t+5)||(x+1==x_t-1&&y+4==y_t+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+2==x_t&&y+4==y_t)||(x+2==x_t+3&&y+4==y_t+3)||(x+2==x_t&&y+4==y_t+6)||(x+2==x_t+1&&y+4==y_t+1)||(x+2==x_t+2&&y+4==y_t+2)||(x+2==x_t+2&&y+4==y_t+4)||(x+2==x_t+1&&y+4==y_t+5)||(x+2==x_t-1&&y+4==y_t)||(x+2==x_t-2&&y+4==y_t+1)||(x+2==x_t-3&&y+4==y_t+2)||(x+2==x_t-4&&y+4==y_t+3)||(x+2==x_t-3&&y+4==y_t+4)||(x+2==x_t-2&&y+4==y_t+5)||(x+2==x_t-1&&y+4==y_t+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+3==x_t&&y+4==y_t)||(x+3==x_t+3&&y+4==y_t+3)||(x+3==x_t&&y+4==y_t+6)||(x+3==x_t+1&&y+4==y_t+1)||(x+3==x_t+2&&y+4==y_t+2)||(x+3==x_t+2&&y+4==y_t+4)||(x+3==x_t+1&&y+4==y_t+5)||(x+3==x_t-1&&y+4==y_t)||(x+3==x_t-2&&y+4==y_t+1)||(x+3==x_t-3&&y+4==y_t+2)||(x+3==x_t-4&&y+4==y_t+3)||(x+3==x_t-3&&y+4==y_t+4)||(x+3==x_t-2&&y+4==y_t+5)||(x+3==x_t-1&&y+4==y_t+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+4==x_t&&y+4==y_t)||(x+4==x_t+3&&y+4==y_t+3)||(x+4==x_t&&y+4==y_t+6)||(x+4==x_t+1&&y+4==y_t+1)||(x+4==x_t+2&&y+4==y_t+2)||(x+4==x_t+2&&y+4==y_t+4)||(x+4==x_t+1&&y+4==y_t+5)||(x+4==x_t-1&&y+4==y_t)||(x+4==x_t-2&&y+4==y_t+1)||(x+4==x_t-3&&y+4==y_t+2)||(x+4==x_t-4&&y+4==y_t+3)||(x+4==x_t-3&&y+4==y_t+4)||(x+4==x_t-2&&y+4==y_t+5)||(x+4==x_t-1&&y+4==y_t+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+5==x_t&&y+4==y_t)||(x+5==x_t+3&&y+4==y_t+3)||(x+5==x_t&&y+4==y_t+6)||(x+5==x_t+1&&y+4==y_t+1)||(x+5==x_t+2&&y+4==y_t+2)||(x+5==x_t+2&&y+4==y_t+4)||(x+5==x_t+1&&y+4==y_t+5)||(x+5==x_t-1&&y+4==y_t)||(x+5==x_t-2&&y+4==y_t+1)||(x+5==x_t-3&&y+4==y_t+2)||(x+5==x_t-4&&y+4==y_t+3)||(x+5==x_t-3&&y+4==y_t+4)||(x+5==x_t-2&&y+4==y_t+5)||(x+5==x_t-1&&y+4==y_t+6)){system("CLS");setcolor(0,0);MP();break;}
////////////////////////////////

if((x==a_b&&y==b_b)||(x==a_b+3&&y==b_b+3)||(x==a_b&&y==b_b+6)||(x==a_b+1&&y==b_b+1)||(x==a_b+2&&y==b_b+2)||(x==a_b+2&&y==b_b+4)||(x==a_b+1&&y==b_b+5)||(x==a_b-1&&y==b_b)||(x==a_b-2&&y==b_b+1)||(x==a_b-3&&y==b_b+2)||(x==a_b-4&&y==b_b+3)||(x==a_b-3&&y==b_b+4)||(x==a_b-2&&y==b_b+5)||(x==a_b-1&&y==b_b+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+1==a_b&&y==b_b)||(x+1==a_b+3&&y==b_b+3)||(x+1==a_b&&y==b_b+6)||(x+1==a_b+1&&y==b_b+1)||(x+1==a_b+2&&y==b_b+2)||(x+1==a_b+2&&y==b_b+4)||(x+1==a_b+1&&y==b_b+5)||(x+1==a_b-1&&y==b_b)||(x+1==a_b-2&&y==b_b+1)||(x+1==a_b-3&&y==b_b+2)||(x+1==a_b-4&&y==b_b+3)||(x+1==a_b-3&&y==b_b+4)||(x+1==a_b-2&&y==b_b+5)||(x+1==a_b-1&&y==b_b+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+2==a_b&&y==b_b)||(x+2==a_b+3&&y==b_b+3)||(x+2==a_b&&y==b_b+6)||(x+2==a_b+1&&y==b_b+1)||(x+2==a_b+2&&y==b_b+2)||(x+2==a_b+2&&y==b_b+4)||(x+2==a_b+1&&y==b_b+5)||(x+2==a_b-1&&y==b_b)||(x+2==a_b-2&&y==b_b+1)||(x+2==a_b-3&&y==b_b+2)||(x+2==a_b-4&&y==b_b+3)||(x+2==a_b-3&&y==b_b+4)||(x+2==a_b-2&&y==b_b+5)||(x+2==a_b-1&&y==b_b+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+3==a_b&&y==b_b)||(x+3==a_b+3&&y==b_b+3)||(x+3==a_b&&y==b_b+6)||(x+3==a_b+1&&y==b_b+1)||(x+3==a_b+2&&y==b_b+2)||(x+3==a_b+2&&y==b_b+4)||(x+3==a_b+1&&y==b_b+5)||(x+3==a_b-1&&y==b_b)||(x+3==a_b-2&&y==b_b+1)||(x+3==a_b-3&&y==b_b+2)||(x+3==a_b-4&&y==b_b+3)||(x+3==a_b-3&&y==b_b+4)||(x+3==a_b-2&&y==b_b+5)||(x+3==a_b-1&&y==b_b+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+4==a_b&&y==b_b)||(x+4==a_b+3&&y==b_b+3)||(x+4==a_b&&y==b_b+6)||(x+4==a_b+1&&y==b_b+1)||(x+4==a_b+2&&y==b_b+2)||(x+4==a_b+2&&y==b_b+4)||(x+4==a_b+1&&y==b_b+5)||(x+4==a_b-1&&y==b_b)||(x+4==a_b-2&&y==b_b+1)||(x+4==a_b-3&&y==b_b+2)||(x+4==a_b-4&&y==b_b+3)||(x+4==a_b-3&&y==b_b+4)||(x+4==a_b-2&&y==b_b+5)||(x+4==a_b-1&&y==b_b+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+5==a_b&&y==b_b)||(x+5==a_b+3&&y==b_b+3)||(x+5==a_b&&y==b_b+6)||(x+5==a_b+1&&y==b_b+1)||(x+5==a_b+2&&y==b_b+2)||(x+5==a_b+2&&y==b_b+4)||(x+5==a_b+1&&y==b_b+5)||(x+5==a_b-1&&y==b_b)||(x+5==a_b-2&&y==b_b+1)||(x+5==a_b-3&&y==b_b+2)||(x+5==a_b-4&&y==b_b+3)||(x+5==a_b-3&&y==b_b+4)||(x+5==a_b-2&&y==b_b+5)||(x+5==a_b-1&&y==b_b+6)){system("CLS");setcolor(0,0);MP();break;}
////////////////////////////////
if((x+1==a_b&&y+1==b_b)||(x+1==a_b+3&&y+1==b_b+3)||(x+1==a_b&&y+1==b_b+6)||(x+1==a_b+1&&y+1==b_b+1)||(x+1==a_b+2&&y+1==b_b+2)||(x+1==a_b+2&&y+1==b_b+4)||(x+1==a_b+1&&y+1==b_b+5)||(x+1==a_b-1&&y+1==b_b)||(x+1==a_b-2&&y+1==b_b+1)||(x+1==a_b-3&&y+1==b_b+2)||(x+1==a_b-4&&y+1==b_b+3)||(x+1==a_b-3&&y+1==b_b+4)||(x+1==a_b-2&&y+1==b_b+5)||(x+1==a_b-1&&y+1==b_b+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+4==a_b&&y+1==b_b)||(x+4==a_b+3&&y+1==b_b+3)||(x+4==a_b&&y+1==b_b+6)||(x+4==a_b+1&&y+1==b_b+1)||(x+4==a_b+2&&y+1==b_b+2)||(x+4==a_b+2&&y+1==b_b+4)||(x+4==a_b+1&&y+1==b_b+5)||(x+4==a_b-1&&y+1==b_b)||(x+4==a_b-2&&y+1==b_b+1)||(x+4==a_b-3&&y+1==b_b+2)||(x+4==a_b-4&&y+1==b_b+3)||(x+4==a_b-3&&y+1==b_b+4)||(x+4==a_b-2&&y+1==b_b+5)||(x+4==a_b-1&&y+1==b_b+6)){system("CLS");setcolor(0,0);MP();break;}
if((x==a_b&&y+2==b_b)||(x==a_b+3&&y+2==b_b+3)||(x==a_b&&y+2==b_b+6)||(x==a_b+1&&y+2==b_b+1)||(x==a_b+2&&y+2==b_b+2)||(x==a_b+2&&y+2==b_b+4)||(x==a_b+1&&y+2==b_b+5)||(x==a_b-1&&y+2==b_b)||(x==a_b-2&&y+2==b_b+1)||(x==a_b-3&&y+2==b_b+2)||(x==a_b-4&&y+2==b_b+3)||(x==a_b-3&&y+2==b_b+4)||(x==a_b-2&&y+2==b_b+5)||(x==a_b-1&&y+2==b_b+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+4==a_b&&y+2==b_b)||(x+4==a_b+3&&y+2==b_b+3)||(x+4==a_b&&y+2==b_b+6)||(x+4==a_b+1&&y+2==b_b+1)||(x+4==a_b+2&&y+2==b_b+2)||(x+4==a_b+2&&y+2==b_b+4)||(x+4==a_b+1&&y+2==b_b+5)||(x+4==a_b-1&&y+2==b_b)||(x+4==a_b-2&&y+2==b_b+1)||(x+4==a_b-3&&y+2==b_b+2)||(x+4==a_b-4&&y+2==b_b+3)||(x+4==a_b-3&&y+2==b_b+4)||(x+4==a_b-2&&y+2==b_b+5)||(x+4==a_b-1&&y+2==b_b+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+1==a_b&&y+3==b_b)||(x+1==a_b+3&&y+3==b_b+3)||(x+1==a_b&&y+3==b_b+6)||(x+1==a_b+1&&y+3==b_b+1)||(x+1==a_b+2&&y+3==b_b+2)||(x+1==a_b+2&&y+3==b_b+4)||(x+1==a_b+1&&y+3==b_b+5)||(x+1==a_b-1&&y+3==b_b)||(x+1==a_b-2&&y+3==b_b+1)||(x+1==a_b-3&&y+3==b_b+2)||(x+1==a_b-4&&y+3==b_b+3)||(x+1==a_b-3&&y+3==b_b+4)||(x+1==a_b-2&&y+3==b_b+5)||(x+1==a_b-1&&y+3==b_b+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+4==a_b&&y+3==b_b)||(x+4==a_b+3&&y+3==b_b+3)||(x+4==a_b&&y+3==b_b+6)||(x+4==a_b+1&&y+3==b_b+1)||(x+4==a_b+2&&y+3==b_b+2)||(x+4==a_b+2&&y+3==b_b+4)||(x+4==a_b+1&&y+3==b_b+5)||(x+4==a_b-1&&y+3==b_b)||(x+4==a_b-2&&y+3==b_b+1)||(x+4==a_b-3&&y+3==b_b+2)||(x+4==a_b-4&&y+3==b_b+3)||(x+4==a_b-3&&y+3==b_b+4)||(x+4==a_b-2&&y+3==b_b+5)||(x+4==a_b-1&&y+3==b_b+6)){system("CLS");setcolor(0,0);MP();break;}

if((x+1==a_b&&y+4==b_b)||(x+1==a_b+3&&y+4==b_b+3)||(x+1==a_b&&y+4==b_b+6)||(x+1==a_b+1&&y+4==b_b+1)||(x+1==a_b+2&&y+4==b_b+2)||(x+1==a_b+2&&y+4==b_b+4)||(x+1==a_b+1&&y+4==b_b+5)||(x+1==a_b-1&&y+4==b_b)||(x+1==a_b-2&&y+4==b_b+1)||(x+1==a_b-3&&y+4==b_b+2)||(x+1==a_b-4&&y+4==b_b+3)||(x+1==a_b-3&&y+4==b_b+4)||(x+1==a_b-2&&y+4==b_b+5)||(x+1==a_b-1&&y+4==b_b+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+2==a_b&&y+4==b_b)||(x+2==a_b+3&&y+4==b_b+3)||(x+2==a_b&&y+4==b_b+6)||(x+2==a_b+1&&y+4==b_b+1)||(x+2==a_b+2&&y+4==b_b+2)||(x+2==a_b+2&&y+4==b_b+4)||(x+2==a_b+1&&y+4==b_b+5)||(x+2==a_b-1&&y+4==b_b)||(x+2==a_b-2&&y+4==b_b+1)||(x+2==a_b-3&&y+4==b_b+2)||(x+2==a_b-4&&y+4==b_b+3)||(x+2==a_b-3&&y+4==b_b+4)||(x+2==a_b-2&&y+4==b_b+5)||(x+2==a_b-1&&y+4==b_b+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+3==a_b&&y+4==b_b)||(x+3==a_b+3&&y+4==b_b+3)||(x+3==a_b&&y+4==b_b+6)||(x+3==a_b+1&&y+4==b_b+1)||(x+3==a_b+2&&y+4==b_b+2)||(x+3==a_b+2&&y+4==b_b+4)||(x+3==a_b+1&&y+4==b_b+5)||(x+3==a_b-1&&y+4==b_b)||(x+3==a_b-2&&y+4==b_b+1)||(x+3==a_b-3&&y+4==b_b+2)||(x+3==a_b-4&&y+4==b_b+3)||(x+3==a_b-3&&y+4==b_b+4)||(x+3==a_b-2&&y+4==b_b+5)||(x+3==a_b-1&&y+4==b_b+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+4==a_b&&y+4==b_b)||(x+4==a_b+3&&y+4==b_b+3)||(x+4==a_b&&y+4==b_b+6)||(x+4==a_b+1&&y+4==b_b+1)||(x+4==a_b+2&&y+4==b_b+2)||(x+4==a_b+2&&y+4==b_b+4)||(x+4==a_b+1&&y+4==b_b+5)||(x+4==a_b-1&&y+4==b_b)||(x+4==a_b-2&&y+4==b_b+1)||(x+4==a_b-3&&y+4==b_b+2)||(x+4==a_b-4&&y+4==b_b+3)||(x+4==a_b-3&&y+4==b_b+4)||(x+4==a_b-2&&y+4==b_b+5)||(x+4==a_b-1&&y+4==b_b+6)){system("CLS");setcolor(0,0);MP();break;}
if((x+5==a_b&&y+4==b_b)||(x+5==a_b+3&&y+4==b_b+3)||(x+5==a_b&&y+4==b_b+6)||(x+5==a_b+1&&y+4==b_b+1)||(x+5==a_b+2&&y+4==b_b+2)||(x+5==a_b+2&&y+4==b_b+4)||(x+5==a_b+1&&y+4==b_b+5)||(x+5==a_b-1&&y+4==b_b)||(x+5==a_b-2&&y+4==b_b+1)||(x+5==a_b-3&&y+4==b_b+2)||(x+5==a_b-4&&y+4==b_b+3)||(x+5==a_b-3&&y+4==b_b+4)||(x+5==a_b-2&&y+4==b_b+5)||(x+5==a_b-1&&y+4==b_b+6)){system("CLS");setcolor(0,0);MP();break;}

if((x==x2_t+5&&y==y2_t+4)||(x+1==x2_t+5&&y==y2_t+4)||(x+2==x2_t+5&&y==y2_t+4)||(x+3==x2_t+5&&y==y2_t+4)||(x+4==x2_t+5&&y==y2_t+4)||(x+5==x2_t+5&&y==y2_t+4)){*score_n=(*score_n)-200;if(*score_n<=0)*score_n=0;}
if((x==a2_b+5&&y==b2_b+4)||(x+1==a2_b+5&&y==b2_b+4)||(x+2==a2_b+5&&y==b2_b+4)||(x+3==a2_b+5&&y==b2_b+4)||(x+4==a2_b+5&&y==b2_b+4)||(x+5==a2_b+5&&y==b2_b+4)){*score_n=(*score_n)-200;if(*score_n<=0)*score_n=0;}
//////////////////////////////////////
}
if(add%count==0){
erase_stone(x_t-1,y_t);
erase_stone(a_b-1,b_b);
erase_bird(x2_t,y2_t-1);
erase_bird(a2_b,b2_b-1);

stone(x_t,y_t);
stone(a_b,b_b);
bird(x2_t,y2_t);
bird(a2_b,b2_b);
x_t<=115;x_t++,a_b++,y2_t++,b2_b++;
}
if(kbhit())
    {
		ch=getch();
		if(ch=='a'&&x>0){direction= -1;}
		if(ch=='d'&&x<108){direction= 1;}
		if(ch=='w'&&y>0){direction= 2;}
		if(ch=='s'&&y<27){direction= -2;}
		if(ch==' '&&jump>=7){jump=jump-7;time=100;*score_n=(*score_n)+100;}
        fflush(stdin);
    }
    if(direction==-1&&x>0){
		erase_man(x,y);man(--x,y);

    }
	if(direction==1&&x<108){
		erase_man(x,y);man(++x,y);


	}
	 if(direction==2&&y>0){
        erase_man(x,y);
		man(x,--y);

	}
	if(direction==-2&&y<27){
        erase_man(x,y);
		man(x,++y);

	}

Sleep(slp_count);
}

if(x_t==116){
erase_stone_end(x_t-1,y_t);
x_t=rand()%80+3;
y_t=rand()%22+1;
}
if(a_b==116){
erase_stone_end(a_b-1,b_b);
a_b=rand()%20+3;
b_b=rand()%22+1;
}
if(y2_t==25){
erase_bird_end(x2_t,y2_t-1);
x2_t=rand()%100+2;
y2_t=rand()%5+1;
}
if(b2_b==25){
erase_bird_end(a2_b,b2_b-1);
a2_b=rand()%100+2;
b2_b=rand()%15+1;
}

for(*score_n=*score_n;;*score_n=(*score_n)+1){
    if(*score_n%7==0){
            *score_n=(*score_n)+1;
        gotoxy(0,0);setcolor(11,12);printf("SCORE : %d  JUMP POINT:  %d  JUMP TIME :  %d  ",*score_n,jump,time);setcolor(0,0);printf("     ");
        gotoxy(0,29);setcolor(13,14);printf("USE HEAD TO SOLVE PROBLEM ");
        gotoxy(39 ,29);setcolor(9,10);printf("7 JUMP POINT = ( 100 JUMP TIME + 100 SCORE ) ");
        gotoxy(95,29);setcolor(12,10);printf("BEAK WILL REDUCE THE SCORE ");
        break;}
}
if(time!=0)time--;
}
}
}
int in_face (int *score){
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
char name[20];
int fp_score;
FILE *fp_game;
fp_game = fopen("E:/Highscore.txt", "r");
if(fp_game==NULL){
fp_score=0;
}
else{
    fscanf(fp_game,"%s%d",name,&fp_score);
}
fclose(fp_game);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
int i,ch;
for(i=1;i<=9;i++){
Sleep(50);
setcolor(i,0); gotoxy(25,5);printf ("           _|        _|                                                  \n");
setcolor(i+1,0);gotoxy(25,6);printf ("   _|_|_|  _|  _|              _|_|_|    _|_|_|  _|_|_|  _|_|      _|_|  \n");
setcolor(i+2,0);gotoxy(25,7);printf (" _|_|      _|_|      _|      _|    _|  _|    _|  _|    _|    _|  _|_|_|_|\n");
setcolor(i+3,0);gotoxy(25,8);printf ("     _|_|  _|  _|    _|      _|    _|  _|    _|  _|    _|    _|  _|      \n");
setcolor(i+4,0);gotoxy(25,9);printf (" _|_|_|    _|    _|  _|        _|_|_|    _|_|_|  _|    _|    _|    _|_|_|\n");
setcolor(i+5,0);gotoxy(25,10);printf("                                   _|                                    \n");
setcolor(i+6,0);gotoxy(25,11);printf("                               _|_|                                      \n");
setcolor(14,0);gotoxy(50,17);printf("PRESS SPACE BAR TO PLAY");
setcolor(13,0);gotoxy(50,18);printf("PRESS 'S' TO VIEW SCORE");
setcolor(11,0);gotoxy(50,19);printf("PRESS 'x' TO EXIT");
setcolor(i,0);gotoxy(35,29);printf("CREATED BY WUTTINUN CHAISIRIVIRAIN (LEON) 59011256");
//setcolor(i,i);gotoxy(1,0);printf("                                                                                                                         ");
//setcolor(i,i);gotoxy(1,28);printf("                                                                                                                         ");

if(i==9)
    i=1;
if(kbhit())
    {
		ch=getch();
		if(ch==' '){setcolor(0,0);
system("CLS");
SetConsoleCP(437);
SetConsoleOutputCP(437);
    setcursor(0);
srand( time( NULL ) );
MP();
int direction=0,x=57,y=7;
int  a=rand()%75+21,b=22;
int a2=rand()%75+21,b2=18;
int a3=rand()%75+21,b3=15;
int a4=rand()%75+21,b4=22;

drawski(x,y);
char ch;
*score=0;
int spd1=50;
for(b=22,b2 = 18,b3 = 15;b>=1;b--,b2--,b3--,b4--){
    draw_tree(a,b);
    draw_tree(a2,b2);
    draw_tree(a3,b3);
    if(*score>=600){
        draw_tree(a4,b4);
    }

    Sleep(spd1);
    erase_tree(a,b);
    erase_tree(a2,b2);
    erase_tree(a3,b3);
    if(*score>=600){
        erase_tree(a4,b4);
    }

    if(b==4){
    a=rand()%75+21,b=23;
   // erase_col();
}
if(b2==4){
    a2=rand()%75+21,b2=23;
   // erase_col();
}
if(b3==4){
    a3=rand()%75+21,b3=23;
   // erase_col();
}
if(b4==4){
    a4=rand()%75+21,b4=23;
}
for(*score=*score;;*score=(*score)+1){
    if(*score>150)
    spd1=25;
    if(*score>1000)
    spd1=15;
    if(*score%1==0){
            *score=(*score)+1;
        gotoxy(0,0);setcolor(6,7);printf("SCORE :   %d   ",*score);
        break;}
}
if((*score%600==0&&*score>300)){
    minimap(&*score);
    direction=0;
    x=57,y=7;
    drawski(x,y);
    }
    //draw_8tree(a2,b2);Sleep(300);erase_tree(a2,b2);
//if(b2==1){
  //  a2=rand()%75+1,b2=19;
   // erase_col();

//}
//////////    draw_tree(a2,b);Sleep(50);erase_tree(a2,b);////////////////////////////////////////////// tree++///////////////////////////////////////////

if(kbhit())
    {
		ch=getch();
		if(ch=='a'&&x>22){direction= -1;}
		if(ch=='d'&&x<94){direction= 1;}
		if(ch=='w'&&y>4){direction= 2;}
		if(ch=='s'&&y<20){direction= -2;}
        fflush(stdin);
    }
    if(direction==-1&&x>22){
		erase(x,y);drawski(--x,y);
		Sleep(10);
	}
	if(direction==1&&x<94){
		erase(x,y);drawski(++x,y);
        Sleep(10);

	}
	 if(direction==2&&y>4){
        erase(x,y);
		drawski(x,--y);
		Sleep(25);
	}
	if(direction==-2&&y<20){
        erase(x,y);
		drawski(x,++y);
        Sleep(25);
	}
/////////////////////////////////////////////////////GAME OVER//////////////////////////////////////////////////////////////////////////////////////////
	if((a==x||a+1==x||a-1==x||a+2==x||a-2==x)&&(b==y||b+1==y||b-1==y)){
        draw_tree(a,b);
        gotoxy(50,10);setcolor(15,25);printf("        GAME OVER            ");
        gotoxy(50,11);setcolor(15,25);printf("PRESS   : ANY KEY TO CONTINUE");
        gotoxy(50,12);setcolor(15,25);printf("  PRESS : ENTER TO END       ");
       if(getch()!=13){
            if(*score>fp_score){
            fp_score=*score;
           FILE *fp_game;
        fp_game=fopen("E:/Highscore.txt","w");
       gotoxy(50,6); printf ("Enter name : ");
        scanf("%s",name);
fprintf (fp_game,"%s ",name);
fprintf (fp_game,"%d",*score);
       setcolor(11,11); gotoxy(50,6); printf ("                                 ");
         }
           erase_tree(a,b);
                   erase_end(a4,b4);

        gotoxy(50,10);setcolor(11,11);printf("                             ");
        gotoxy(50,11);setcolor(11,11);printf("                             ");
        gotoxy(50,12);setcolor(11,11);printf("                             ");
        erase_end(a,b);
        erase(x,y);
        *score=0;
        spd1=50;
        direction=99;
        b=20;
        x=57,y=7;
        drawski(x,y);
        gotoxy(20,22);setcolor(4,4);printf("*******************************************************************************");
        gotoxy(20,23);setcolor(0,0);printf("*******************************************************************************");
        gotoxy(20,24);setcolor(0,0);printf("*******************************************************************************");
        }
       else{
         if(*score>fp_score){
                fp_score=*score;
           FILE *fp_game;
        fp_game=fopen("E:/Highscore.txt","w");
        gotoxy(50,6);printf ("Enter name : ");
        scanf("%s",name);
fprintf (fp_game,"%s ",name);
fprintf (fp_game,"%d",*score);
         }
        setcolor(0,0);system("CLS");
       break;}
	}
    else if((a2==x||a2+1==x||a2-1==x||a2+2==x||a2-2==x)&&(b2==y||b2+1==y||b2-1==y)){
        draw_tree(a2,b2);
        gotoxy(50,10);setcolor(15,25);printf("        GAME OVER            ");
        gotoxy(50,11);setcolor(15,25);printf("PRESS   : ANY KEY TO CONTINUE");
        gotoxy(50,12);setcolor(15,25);printf("  PRESS : ENTER TO END       ");
       if(getch()!=13){
            if(*score>fp_score){
            fp_score=*score;
           FILE *fp_game;
        fp_game=fopen("E:/Highscore.txt","w");
       gotoxy(50,6); printf ("Enter name : ");
        scanf("%s",name);
fprintf (fp_game,"%s ",name);
fprintf (fp_game,"%d",*score);
       setcolor(11,11); gotoxy(50,6); printf ("                                   ");
         }
           erase_tree(a2,b2);
                   erase_end(a4,b4);

        gotoxy(50,10);setcolor(11,11);printf("                             ");
        gotoxy(50,11);setcolor(11,11);printf("                             ");
        gotoxy(50,12);setcolor(11,11);printf("                             ");
        erase_end(a2,b2);
        erase(x,y);
        *score=0;
        spd1=50;
        direction=99;
        b2=20;
        x=57,y=7;
        drawski(x,y);
        gotoxy(20,22);setcolor(4,4);printf("*******************************************************************************");
        gotoxy(20,23);setcolor(0,0);printf("*******************************************************************************");
        gotoxy(20,24);setcolor(0,0);printf("*******************************************************************************");}
       else{
           if(*score>fp_score){
            fp_score=*score;
           FILE *fp_game;
        fp_game=fopen("E:/Highscore.txt","w");
       gotoxy(50,6); printf ("Enter name : ");
        scanf("%s",name);
fprintf (fp_game,"%s ",name);
fprintf (fp_game,"%d",*score);
         }
        setcolor(0,0);system("CLS");
       break;}
	}
	 else if((a3==x||a3+1==x||a3-1==x||a3+2==x||a3-2==x)&&(b3==y||b3+1==y||b3-1==y)){
        draw_tree(a3,b3);
        gotoxy(50,10);setcolor(15,25);printf("        GAME OVER            ");
        gotoxy(50,11);setcolor(15,25);printf("PRESS   : ANY KEY TO CONTINUE");
        gotoxy(50,12);setcolor(15,25);printf("  PRESS : ENTER TO END       ");
       if(getch()!=13){
            if(*score>fp_score){
            fp_score=*score;
           FILE *fp_game;
        fp_game=fopen("E:/Highscore.txt","w");
       gotoxy(50,6); printf ("Enter name : ");
        scanf("%s",name);
fprintf (fp_game,"%s ",name);
fprintf (fp_game,"%d",*score);
       setcolor(11,11); gotoxy(50,6); printf ("                                    ");
         }
           erase_tree(a3,b3);
                   erase_end(a4,b4);

        gotoxy(50,10);setcolor(11,11);printf("                             ");
        gotoxy(50,11);setcolor(11,11);printf("                             ");
        gotoxy(50,12);setcolor(11,11);printf("                             ");
        erase_end(a3,b3);
        erase(x,y);
        *score=0;
        spd1=50;
        direction=99;
        b3=20;
        x=57,y=7;
        drawski(x,y);
        gotoxy(20,22);setcolor(4,4);printf("*******************************************************************************");
        gotoxy(20,23);setcolor(0,0);printf("*******************************************************************************");
        gotoxy(20,24);setcolor(0,0);printf("*******************************************************************************");}
       else{
            if(*score>fp_score){
                    fp_score=*score;
           FILE *fp_game;
        fp_game=fopen("E:/Highscore.txt","w");
      gotoxy(50,6);  printf ("Enter name : ");
        scanf("%s",name);
fprintf (fp_game,"%s ",name);
fprintf (fp_game,"%d",*score);
         }
         setcolor(0,0);system("CLS");
       break;}
	}
	 else if((a4==x||a4+1==x||a4-1==x||a4+2==x||a4-2==x)&&(b4==y||b4+1==y||b4-1==y)&&*score>=1000){
        draw_tree(a4,b4);
        gotoxy(50,10);setcolor(15,25);printf("        GAME OVER            ");
        gotoxy(50,11);setcolor(15,25);printf("PRESS   : ANY KEY TO CONTINUE");
        gotoxy(50,12);setcolor(15,25);printf("  PRESS : ENTER TO END       ");
       if(getch()!=13){
                       erase_tree(a4,b4);

            if(*score>fp_score){
            fp_score=*score;
           FILE *fp_game;
        fp_game=fopen("E:/Highscore.txt","w");
       gotoxy(50,6); printf ("Enter name : ");
        scanf("%s",name);
fprintf (fp_game,"%s ",name);
fprintf (fp_game,"%d",*score);
       setcolor(11,11); gotoxy(48,6); printf ("                                   ");
         }
           erase_tree(a4,b4);
        gotoxy(50,10);setcolor(11,11);printf("                             ");
        gotoxy(50,11);setcolor(11,11);printf("                             ");
        gotoxy(50,12);setcolor(11,11);printf("                             ");
        erase_end(a4,b4);
        erase(x,y);
        *score=0;
        spd1=50;
        direction=99;
        b4=20;
        x=57,y=7;
        drawski(x,y);
        gotoxy(20,22);setcolor(4,4);printf("*******************************************************************************");
        gotoxy(20,23);setcolor(0,0);printf("*******************************************************************************");
        gotoxy(20,24);setcolor(0,0);printf("*******************************************************************************");}
       else{
           if(*score>fp_score){
                fp_score=*score;
           FILE *fp_game;
        fp_game=fopen("E:/Highscore.txt","w");
       gotoxy(50,6); printf ("Enter name : ");
        scanf("%s",name);
fprintf (fp_game,"%s ",name);
fprintf (fp_game,"%d",*score);
         }
         setcolor(0,0);system("CLS");
       break;}
	}
}
}
		if(ch=='x'){ setcolor(0,0);exit(EXIT_SUCCESS);}
        if(ch=='s'){

        setcolor(0,0);
        system("CLS");
        FILE *fp_game;
        fp_game=fopen("E:/Highscore.txt","r");
        if(fp_game==NULL){
        gotoxy(50,12);setcolor(4,0);printf("HIGH");setcolor(5,0);printf(" SCORE ");setcolor(6,0);printf("IS ");setcolor(7,0);printf("EMPTY");}
        else{
        fscanf(fp_game,"%s",name);
        fscanf(fp_game,"%d",&fp_score);
        gotoxy(48,12);setcolor(10,0);printf("|||||| ");setcolor(12,0);printf("HIGH SCORE");setcolor(10,0);printf(" ||||||");
        gotoxy(48,14);
       // if(fp_score<score){
       //         setcolor(11,0); printf("      %s ",name);
       //         setcolor(13,0); printf("%d\n",//score);}
       // else{
                     setcolor(11,0); printf("      %s ",name);
                     setcolor(13,0); printf("%d\n",fp_score);
        gotoxy(48,16);setcolor(10,0);printf("||||||||||||||||||||||||");}//}
        gotoxy(47,20);system("PAUSE");
        system("CLS");

        }
        fflush(stdin);
    }
}
}
int main(){
system("MODE 123,30");
in_face(&score);
}
