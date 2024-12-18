package hexlet.code.formats;

import hexlet.code.Utilites.Stat;

import java.util.List;
import java.util.Map;

import static hexlet.code.Utilites.STATUS;
import static hexlet.code.Utilites.KEY;
import static hexlet.code.Utilites.VALUE1;
import static hexlet.code.Utilites.VALUE2;

public class MakeStylish {
    public static String makeStylish(List<Map<String, Object>> base) {
        StringBuilder outputString = null;

        outputString = new StringBuilder("{");
        outputString.append(System.lineSeparator());
        for (var i: base) {
            String valueOne = "";
            if (i.get(VALUE1) != null) {
                valueOne = i.get(VALUE1).toString();
            } else {
                valueOne = "null";
            }

            switch (i.get(STATUS)) {
                case Stat.ADD: outputString.append("  + ");
                    break;
                case Stat.REMOVE: outputString.append("  - ");
                    break;
                case Stat.INVARIABLY: outputString.append("    ");
                    break;
                case Stat.CHANGE:
                    outputString.append("  - ").append(i.get(KEY)).append(": ").
                            append(valueOne).append(System.lineSeparator());
                    if (i.get(VALUE2) != null) {
                        valueOne = i.get(VALUE2).toString();
                    } else {
                        valueOne = "null";
                    }
                    outputString.append("  + ");
                    break;
                default:
                    break;
            }
            outputString.append(i.get(KEY)).append(": ").append(valueOne).append(System.lineSeparator());
        }
        return outputString.append("}").toString();
    }
}
