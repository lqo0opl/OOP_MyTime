package First;

public class MyTime {
    private int hours;
    private int minutes;
    private int seconds;
    private boolean meridian;

    public MyTime(){}

    public void setMyTime(int hours, int minutes, int seconds, boolean meridian){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.meridian =meridian;
    }
    
    public void advanceTime(int seconds){
        int allsec = this.seconds + seconds;
        int allmin = this.minutes + ((allsec)/60);
        int allhour = this.hours + ((allmin)/60);

        //For Seconds
        if((allsec) >= 60){
            this.seconds = (allsec) - (60*((allsec)/60));

            // For Minutes
            if((allmin) >= 60){
                this.minutes = (allmin)-(60*((allmin)/60));
            }else{
                this.minutes = allmin;
            }

            //For Hours
            if(allhour > 12){
                this.hours = allhour - (12*((allhour)/12));
            }else{
                this.hours = allhour;
                for(int i=0; i<(allhour/12); i++){
                    this.meridian = !this.meridian;
                }
            }
           
        }else{
            this.seconds = this.seconds+seconds;
        }
    }

    public void tickByMinute(){
        if((this.minutes + 1) == 60){
            this.minutes = 0;
            if((this.hours + 1) == 12){
            this.hours = this.hours + 1;
            this.meridian = !this.meridian;
        }else{
            if((this.hours + 1) > 12){
                this.hours = (this.hours-12) + 1;
            }else{
                this.hours = this.hours + 1;
            }
        }
        }else{
            this.minutes = this.minutes + 1;
        }
    }

    public void tickByHour(){
        if((this.hours + 1) == 12){
            this.hours = this.hours + 1;
            this.meridian = !this.meridian;
        }else{
            if((this.hours + 1) > 12){
                this.hours = (this.hours-12) + 1;
            }else{
                this.hours = this.hours + 1;
            }
        }
    }

    public void tickBySecond(){
        //For Seconds
        if((this.seconds + 1) == 60){
            this.seconds = 0;

            //For Minutes
            if((this.minutes + 1) == 60){
                this.minutes = 0;

                //For Hours
                if((this.hours + 1) == 12){
                    this.hours = this.hours + 1;
                    this.meridian = !this.meridian;
                }else{
                    if((this.hours + 1) > 12){
                        this.hours = (this.hours-12) + 1;
                    }else{
                        this.hours = this.hours + 1;
                    }
                }
            }
        }else{
            this.seconds = this.seconds + 1;
        }
    }

    public void display12(MyTime time){
        if(time.meridian == true){
            System.out.printf("%d:%d:%d AM\n", time.hours, time.minutes, time.seconds);
        }else{
            System.out.printf("%d:%d:%d PM\n", time.hours, time.minutes, time.seconds);
        }
    }

    public void display24(MyTime time){
        if(time.meridian == true){
            System.out.printf("%d:%d:%d AM\n", time.hours, time.minutes, time.seconds);
        }else{
            System.out.printf("%d:%d:%d PM\n", time.hours + 12, time.minutes, time.seconds);
        }
    }

    public String toString(){
        return hours+":"+minutes+":"+seconds+(this.meridian?" AM":" PM");
    }

}
