public class StringFilterIsItLowerCase implements Filter{
    @Override
    public Object apply(Object o) {
        if (o instanceof String str) {
            // Проверяем, что строка полностью в нижнем регистре
            if (str.equals(str.toLowerCase())) {
                return str;
            }
        }
        return null;
    }
}