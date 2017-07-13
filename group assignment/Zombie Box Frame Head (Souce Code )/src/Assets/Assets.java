package Assets;

import Loader.ImageLoader;
import SpriteSheet.SpriteSheet;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Assets {

    public static BufferedImage player,grass,tree,water,monster,it,house,road,car,road1,road2,road3,road4,road5,road6;
    public static BufferedImage [] player_down,player_left,player_right,player_up;
    public static BufferedImage [] playerShotgun_down,playerShotgun_left,playerShotgun_right,playerShotgun_up;
    public static BufferedImage [] playerAK_down,playerAK_left,playerAK_right , playerAK_up;
    public static BufferedImage [] zombie_down,zombie_left,zombie_right,zombie_up;
    public static BufferedImage [] zombieMc_down,zombieMc_left,zombieMc_right,zombieMc_up;
    public static BufferedImage [] zombieTank_down,zombieTank_left,zombieTank_right,zombieTank_up;
    public static BufferedImage [] boss_down,boss_left,boss_right,boss_up;
    public static BufferedImage [] player2_down,player2_left,player2_right,player2_up;
    public static BufferedImage [] player2Shotgun_down,player2Shotgun_left,player2Shotgun_right,player2Shotgun_up;
    public static BufferedImage [] player2AK_down,player2AK_left,player2AK_right , player2AK_up;
    public static Media AK;

    private static final int width = 32;
    private static final int height = 32;
    public Assets(){
        SpriteSheet building = new SpriteSheet(ImageLoader.loadImage("/building.png"));
        SpriteSheet playerShotgun     = new SpriteSheet(ImageLoader.loadImage("/player1Shotgun.png"));
        SpriteSheet playerAK    = new SpriteSheet(ImageLoader.loadImage("/player1AK.png"));
        SpriteSheet player     = new SpriteSheet(ImageLoader.loadImage("/player1.png"));
        SpriteSheet player2AK    = new SpriteSheet(ImageLoader.loadImage("/player2AK.png"));
        SpriteSheet player2Shotgun     = new SpriteSheet(ImageLoader.loadImage("/player2Shotgun.png"));
        SpriteSheet player2    = new SpriteSheet(ImageLoader.loadImage("/player2.png"));
        SpriteSheet zombie     = new SpriteSheet(ImageLoader.loadImage("/zombie_1.png"));
        SpriteSheet boss = new SpriteSheet(ImageLoader.loadImage("/Boss.png"));
        SpriteSheet zombieMc = new SpriteSheet(ImageLoader.loadImage("/zombieMc.png"));
        SpriteSheet zombieTank = new SpriteSheet(ImageLoader.loadImage("/zombieTank.png"));
        SpriteSheet roadd    = new SpriteSheet(ImageLoader.loadImage("/Roadgg.png"));
        AK = new Media(getClass().getResource("/Gun+1.wav").toExternalForm());




        playerShotgun_left = new BufferedImage[3];
        playerShotgun_right = new BufferedImage[3];
        playerShotgun_up = new BufferedImage[2];
        playerShotgun_down = new BufferedImage[2];

        playerAK_left = new BufferedImage[3];
        playerAK_right = new BufferedImage[3];
        playerAK_up = new BufferedImage[2];
        playerAK_down = new BufferedImage[2];

        player_left = new BufferedImage[3];
        player_right = new BufferedImage[3];
        player_up = new BufferedImage[2];
        player_down = new BufferedImage[2];

        player2Shotgun_left = new BufferedImage[3];
        player2Shotgun_right = new BufferedImage[3];
        player2Shotgun_up = new BufferedImage[2];
        player2Shotgun_down = new BufferedImage[2];

        player2AK_left = new BufferedImage[3];
        player2AK_right = new BufferedImage[3];
        player2AK_up = new BufferedImage[2];
        player2AK_down = new BufferedImage[2];

        player2_left = new BufferedImage[3];
        player2_right = new BufferedImage[3];
        player2_up = new BufferedImage[2];
        player2_down = new BufferedImage[2];

        zombie_up = new BufferedImage[2];
        zombie_down = new BufferedImage[2];
        zombie_left = new BufferedImage[2];
        zombie_right = new BufferedImage[2];

        zombieMc_up = new BufferedImage[2];
        zombieMc_down = new BufferedImage[2];
        zombieMc_left = new BufferedImage[2];
        zombieMc_right = new BufferedImage[2];

        zombieTank_up = new BufferedImage[2];
        zombieTank_down = new BufferedImage[2];
        zombieTank_left = new BufferedImage[2];
        zombieTank_right = new BufferedImage[2];


        boss_up = new BufferedImage[2];
        boss_down = new BufferedImage[2];
        boss_left = new BufferedImage[3];
        boss_right = new BufferedImage[3];



        player_left[0] = player.crop(0, 0, 32, 32);
        player_left[1] = player.crop(32, 0, 32, 32);
        player_left[2] = player.crop(64, 0, 32, 32);


        player_right[0] = player.crop(96,0,32,32);
        player_right[1] = player.crop(128,0,32,32);
        player_right[2] = player.crop(160,0,32,32);


        player_down[0] = player.crop(192,0,32,32);
        player_down[1] = player.crop(224,0,32,32);

        player_up[0] = player.crop(256,0,32,32);
        player_up[1] = player.crop(288,0,32,32);


        playerAK_left[0] = playerAK .crop(0, 0, 32, 32);
        playerAK_left[1] = playerAK .crop(32, 0, 32, 32);
        playerAK_left[2] = playerAK .crop(64, 0, 32, 32);


        playerAK_right[0] = playerAK .crop(96,0,32,32);
        playerAK_right[1] = playerAK .crop(128,0,32,32);
        playerAK_right[2] = playerAK .crop(160,0,32,32);


        playerAK_down[0] = playerAK .crop(192,0,32,32);
        playerAK_down[1] = playerAK .crop(224,0,32,32);

        playerAK_up[0] = playerAK .crop(256,0,32,32);
        playerAK_up[1] = playerAK .crop(288,0,32,32);

        playerShotgun_left[0] = playerShotgun.crop(0, 0, 32, 32);
        playerShotgun_left[1] = playerShotgun.crop(32, 0, 32, 32);
        playerShotgun_left[2] = playerShotgun.crop(64, 0, 32, 32);


        playerShotgun_right[0] = playerShotgun.crop(96,0,32,32);
        playerShotgun_right[1] = playerShotgun.crop(128,0,32,32);
        playerShotgun_right[2] = playerShotgun.crop(160,0,32,32);


        playerShotgun_down[0] = playerShotgun.crop(192,0,32,32);
        playerShotgun_down[1] = playerShotgun.crop(224,0,32,32);

        playerShotgun_up[0] = playerShotgun.crop(256,0,32,32);
        playerShotgun_up[1] = playerShotgun.crop(288,0,32,32);


        player2_left[0] = player2.crop(0, 0, 32, 32);
        player2_left[1] = player2.crop(32, 0, 32, 32);
        player2_left[2] = player2.crop(64, 0, 32, 32);


        player2_right[0] = player2.crop(96,0,32,32);
        player2_right[1] = player2.crop(128,0,32,32);
        player2_right[2] = player2.crop(160,0,32,32);


        player2_down[0] = player2.crop(192,0,32,32);
        player2_down[1] = player2.crop(224,0,32,32);

        player2_up[0] = player2.crop(256,0,32,32);
        player2_up[1] = player2.crop(288,0,32,32);

        player2AK_left[0] = player2AK .crop(0, 0, 32, 32);
        player2AK_left[1] = player2AK .crop(32, 0, 32, 32);
        player2AK_left[2] = player2AK .crop(64, 0, 32, 32);


        player2AK_right[0] = player2AK .crop(96,0,32,32);
        player2AK_right[1] = player2AK .crop(128,0,32,32);
        player2AK_right[2] = player2AK .crop(160,0,32,32);


        player2AK_down[0] = player2AK .crop(192,0,32,32);
        player2AK_down[1] = player2AK .crop(224,0,32,32);

        player2AK_up[0] = player2AK .crop(256,0,32,32);
        player2AK_up[1] = player2AK .crop(288,0,32,32);

        player2Shotgun_left[0] = player2Shotgun.crop(0, 0, 32, 32);
        player2Shotgun_left[1] = player2Shotgun.crop(32, 0, 32, 32);
        player2Shotgun_left[2] = player2Shotgun.crop(64, 0, 32, 32);


        player2Shotgun_right[0] = player2Shotgun.crop(96,0,32,32);
        player2Shotgun_right[1] = player2Shotgun.crop(128,0,32,32);
        player2Shotgun_right[2] = player2Shotgun.crop(160,0,32,32);


        player2Shotgun_down[0] = player2Shotgun.crop(192,0,32,32);
        player2Shotgun_down[1] = player2Shotgun.crop(224,0,32,32);

        player2Shotgun_up[0] = player2Shotgun.crop(256,0,32,32);
        player2Shotgun_up[1] = player2Shotgun.crop(288,0,32,32);

        zombie_left[0] = zombie.crop(0,0,32,32);
        zombie_left[1]  = zombie.crop(32,0,32,32);

        zombie_right[0] = zombie.crop(64,0,32,32);
        zombie_right[1]  = zombie.crop(96,0,32,32);

        zombie_down[0] = zombie.crop(128,0,32,32);
        zombie_down[1]  = zombie.crop(160,0,32,32);

        zombie_up[0] = zombie.crop(192,0,32,32);
        zombie_up[1]  = zombie.crop(224,0,32,32);

        zombieMc_left[0] = zombieMc.crop(0,0,32,32);
        zombieMc_left[1]  = zombieMc.crop(32,0,32,32);

        zombieMc_right[0] = zombieMc.crop(64,0,32,32);
        zombieMc_right[1]  = zombieMc.crop(96,0,32,32);

        zombieMc_down[0] = zombieMc.crop(128,0,32,32);
        zombieMc_down[1]  = zombieMc.crop(160,0,32,32);

        zombieMc_up[0] = zombieMc.crop(192,0,32,32);
        zombieMc_up[1]  = zombieMc.crop(224,0,32,32);

        zombieTank_left[0] = zombieTank.crop(0,0,32,32);
        zombieTank_left[1]  = zombieTank.crop(32,0,32,32);

        zombieTank_right[0] = zombieTank.crop(64,0,32,32);
        zombieTank_right[1]  = zombieTank.crop(96,0,32,32);

        zombieTank_down[0] = zombieTank.crop(128,0,32,32);
        zombieTank_down[1]  = zombieTank.crop(160,0,32,32);

        zombieTank_up[0] = zombieTank.crop(192,0,32,32);
        zombieTank_up[1]  = zombieTank.crop(224,0,32,32);

        boss_left[0] = boss.crop(0,0,64,64);
        boss_left[1]  = boss.crop(64,0,64,64);
        boss_left[2]  = boss.crop(128,0,64,64);

        boss_right[0] = boss.crop(192,0,64,64);
        boss_right[1]  = boss.crop(256,0,64,64);
        boss_right[2]  = boss.crop(320,0,64,64);

        boss_down[0] = boss.crop(384,0,64,64);
        boss_down[1]  = boss.crop(448,0,64,64);

        boss_up[0] = boss.crop(512,0,64,64);
        boss_up[1]  = boss.crop(576,0,64,64);


        grass = building.crop(96,32,32,32);
        it = building.crop(64,32,32,32);
        house = building.crop(0,0,64,64);
        road = ImageLoader.loadImage("/road.png").getSubimage(0,0,32,32);
        car = building.crop(64,0,64,32);


        road1 = roadd.crop(0,0,32,32);
        road2 = roadd.crop(32,0,32,32);
        road3 = roadd.crop(64,0,32,32);
        road4 = roadd.crop(96,0,32,32);
        road5 = roadd.crop(128,0,32,32);
        road6 = roadd.crop(160,0,32,32);

    }
}
