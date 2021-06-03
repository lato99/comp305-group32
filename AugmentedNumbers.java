public class AugmentedNumber implements Comparable<AugmentedNumber> {
    private int belongedStudent;
    private int numberItself;

    public AugmentedNumber(int belongedStudent, int numberItself) {
        this.belongedStudent = belongedStudent;
        this.numberItself = numberItself;
    }

   

    @Override
    public int compareTo(AugmentedNumber num) {
        if (this.numberItself == num.numberItself()) {
            return 0;
        } else if (this.num > num.numberItself()) {
            return 1;
        } else {
            return -1;
        }
    }
}