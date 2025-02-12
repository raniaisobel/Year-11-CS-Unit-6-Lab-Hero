public class Hero {
    private String name;
    private int hitPoints;

    public Hero(String name){
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName(){
        return name;
    }

    public int getHitPoints(){
        return hitPoints;
    }

    public String toString(){
        return "Hero{name='"+name+"', hitPoints="+hitPoints+"}";
    }

    public void attack(Hero opponent){
        double random = Math.random();
        if(random>=0.5){
            this.hitPoints = hitPoints-10;
        }
        else{
            opponent.hitPoints = opponent.hitPoints-10;
        }
    }

    public void senzuBean(){
        this.hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent){
        while(this.hitPoints>0 && opponent.hitPoints>0){
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent){
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name+": "+this.hitPoints+"        "+opponent.name+": "+opponent.hitPoints;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int[] winLose = new int[2];
        for(int i=0; i<n; i++){
            fightUntilTheDeath(opponent);
            if(this.hitPoints==0){
                winLose[1] = winLose[1]+1;
            }
            else{
                winLose[0] = winLose[0]+1;
            }
            senzuBean();
        }
        return winLose;
    }

    public String nFightsToTheDeath(Hero opponent, int n){
        int[] winLosses = nFightsToTheDeathHelper(opponent, n);
        if (winLosses[0]==winLosses[1]){
            return this.name+": "+winLosses[0]+" wins\n"+opponent.name+": "+winLosses[1]+" wins\n"+"OMG! It was actually a draw!";
        }
        else if(winLosses[0]>winLosses[1]){
            return this.name+": "+winLosses[0]+" wins\n"+opponent.name+": "+winLosses[1]+" wins\n"+this.name+" wins!";
        }
        else{
            return this.name+": "+winLosses[0]+" wins\n"+opponent.name+": "+winLosses[1]+" wins\n"+opponent.name+" wins!";
        }
    }

    public void dramaticFightToTheDeath(Hero opponent){
        while(this.hitPoints>0 && opponent.hitPoints>0){
            attack(opponent);
            System.out.println(this.name + ": " + this.hitPoints);
            System.out.println(opponent.name + ": " + opponent.hitPoints);
        }
        if(this.hitPoints==0){
            System.out.println(opponent.name+" wins!");
        }
        else{
            System.out.println(this.name+" wins!");
        }
    }
}
