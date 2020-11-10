public class AdapterImplements implements Adapter{
    @Override
    public Integer twiceOf(Integer integer) {
        return Double.valueOf(Math.twiceOf(integer.doubleValue())).intValue();
    }

    @Override
    public Integer halfOf(Integer integer) {
        return Double.valueOf(Math.halfOf(integer.doubleValue())).intValue();
    }
}
