package JavaMemoryModel2;

import java.awt.*;

public class FrameExchanger {

    private  long framesStoredCount=0;
    private  long framesTakenCount=0;

    private  volatile  boolean hasNewFrame = false;
    private Frame frame = null;


    public  void storeFrame(Frame frame){
        this.frame =frame;
        this.framesStoredCount++;
        this.hasNewFrame = true;

    }

    public Frame takeFrame(){
        while (!hasNewFrame){
            //busy wait until new frame arrives
        }

        Frame newFrame = this.frame;
        this.framesTakenCount++;
        this.hasNewFrame = false;
        return newFrame;
    }
}
