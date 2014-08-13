package com.epam.bp.TempName.action;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private static final Map<String, Action> actions = new HashMap<>();

    static {
        actions.put("RepeatTextAction", new RepeatTextAction());
    }

    public static Action getAction(String actionName) {
        return actions.get(actionName);
    }
}
