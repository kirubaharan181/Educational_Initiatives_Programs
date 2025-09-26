import java.util.ArrayList;
import java.util.List;

interface ScoreWatcher {
    void update(int runs, int wickets);
}

class CricketScore {
    private int runs = 0;
    private int wickets = 0;
    private List<ScoreWatcher> watchers = new ArrayList<>();

    public void addWatcher(ScoreWatcher watcher) {
        watchers.add(watcher);
    }

    public void removeWatcher(ScoreWatcher watcher) {
        watchers.remove(watcher);
    }

    public void updateScore(int newRuns, int newWickets) {
        runs = newRuns;
        wickets = newWickets;
        notifyWatchers();
    }

    private void notifyWatchers() {
        for (ScoreWatcher watcher : watchers) {
            watcher.update(runs, wickets);
        }
    }
}

class PhoneApp implements ScoreWatcher {
    public void update(int runs, int wickets) {
        System.out.println("Phone App: Runs = " + runs + ", Wickets = " + wickets);
    }
}

class TVDisplay implements ScoreWatcher {
    public void update(int runs, int wickets) {
        System.out.println("TV Display: Runs = " + runs + ", Wickets = " + wickets);
    }
}

interface BattingStyle {
    void play();
}

class SafePlay implements BattingStyle {
    public void play() {
        System.out.println("Plays safe, takes singles.");
    }
}

class BoldPlay implements BattingStyle {
    public void play() {
        System.out.println("Plays bold, hits boundaries!");
    }
}

class Batter {
    private BattingStyle style;

    public void setStyle(BattingStyle newStyle) {
        style = newStyle;
    }

    public void hitShot() {
        style.play();
    }
}

class MatchBoard {
    private static MatchBoard board;
    private int runs = 0, wickets = 0;

    private MatchBoard() {
    }

    public static MatchBoard getBoard() {
        if (board == null) {
            board = new MatchBoard();
        }
        return board;
    }

    public void addRuns(int r) {
        runs += r;
    }

    public void addWicket() {
        wickets++;
    }

    public void showScore() {
        System.out.println("Score: " + runs + "/" + wickets);
    }
}

abstract class TeamPlayer {
    String name;

    public TeamPlayer(String name) {
        this.name = name;
    }

    public abstract void showRole();
}

class BatterPlayer extends TeamPlayer {
    public BatterPlayer(String name) {
        super(name);
    }

    public void showRole() {
        System.out.println(name + " is a Batter.");
    }
}

class Bowler extends TeamPlayer {
    public Bowler(String name) {
        super(name);
    }

    public void showRole() {
        System.out.println(name + " is a Bowler.");
    }
}

class AllRounder extends TeamPlayer {
    public AllRounder(String name) {
        super(name);
    }

    public void showRole() {
        System.out.println(name + " is an All-Rounder.");
    }
}

class PlayerMaker {
    public static TeamPlayer makePlayer(String type, String name) {
        switch (type.toLowerCase()) {
            case "batter":
                return new BatterPlayer(name);
            case "bowler":
                return new Bowler(name);
            case "allrounder":
                return new AllRounder(name);
            default:
                throw new IllegalArgumentException("Unknown player type!");
        }
    }
}

class OldScore {
    public String getScore() {
        return "120/3 in 15 overs";
    }
}

interface NewScoreDisplay {
    void showScore();
}

class ScoreConverter implements NewScoreDisplay {
    private OldScore oldScore;

    public ScoreConverter(OldScore oldScore) {
        this.oldScore = oldScore;
    }

    public void showScore() {
        System.out.println("New Score: " + oldScore.getScore());
    }
}

interface Stats {
    void show();
}

class BasicStats implements Stats {
    public void show() {
        System.out.println("Basic Stats: Runs/Wickets");
    }
}

class StrikeRate implements Stats {
    private Stats stats;

    public StrikeRate(Stats stats) {
        this.stats = stats;
    }

    public void show() {
        stats.show();
        System.out.println("Strike Rate: 135.0");
    }
}

class EconomyRate implements Stats {
    private Stats stats;

    public EconomyRate(Stats stats) {
        this.stats = stats;
    }

    public void show() {
        stats.show();
        System.out.println("Economy Rate: 6.5");
    }
}

public class CricketApp {
    public static void main(String[] args) {

        System.out.println("=== Score Update Test ===");
        CricketScore score = new CricketScore();
        score.addWatcher(new PhoneApp());
        score.addWatcher(new TVDisplay());
        score.updateScore(45, 1);
        System.out.println();

        System.out.println("=== Batting Style Test ===");
        Batter batter = new Batter();
        batter.setStyle(new SafePlay());
        batter.hitShot();
        batter.setStyle(new BoldPlay());
        batter.hitShot();
        System.out.println();

        System.out.println("=== Scoreboard Test ===");
        MatchBoard board = MatchBoard.getBoard();
        board.addRuns(4);
        board.showScore();
        System.out.println();

        System.out.println("=== Player Creation Test ===");
        TeamPlayer p1 = PlayerMaker.makePlayer("batter", "Rohit");
        p1.showRole();
        TeamPlayer p2 = PlayerMaker.makePlayer("bowler", "Bumrah");
        p2.showRole();
        TeamPlayer p3 = PlayerMaker.makePlayer("allrounder", "Jadeja");
        p3.showRole();
        System.out.println();

        System.out.println("=== Old Score Adapter Test ===");
        OldScore old = new OldScore();
        NewScoreDisplay converter = new ScoreConverter(old);
        converter.showScore();
        System.out.println();

        System.out.println("=== Player Stats Test ===");
        Stats stats = new BasicStats();
        Stats enhancedStats = new StrikeRate(new EconomyRate(stats));
        enhancedStats.show();
        System.out.println();
    }
}