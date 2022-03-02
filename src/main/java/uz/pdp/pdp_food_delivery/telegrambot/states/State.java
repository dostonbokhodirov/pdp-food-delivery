package uz.pdp.pdp_food_delivery.telegrambot.states;

import uz.pdp.pdp_food_delivery.telegrambot.enums.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class State {
    private static final Map<String, UState> userState = new HashMap<>();
    private static final Map<String, SettingsState> settingsState = new HashMap<>();
    private static final Map<String, MenuState> menuState = new HashMap<>();
    private static final Map<String, ContactState> contactState = new HashMap<>();
    private static final Map<String, ManagerState> managerState = new HashMap<>();
    private static final Map<String, SearchState> searchState = new HashMap<>();
    private static final Map<String, Integer> limitState = new HashMap<>();


    public synchronized static void setState(String chatId, UState state) {
        userState.put(chatId, state);
    }

    public synchronized static void setSettingsState(String chatId, SettingsState state) {
        settingsState.put(chatId, state);
    }

    public synchronized static void setMenuState(String chatId, MenuState state) {
        menuState.put(chatId, state);
    }

    public static void setContactState(String chatId, ContactState state) {
        contactState.put(chatId, state);
    }

    public synchronized static void setManagerState(String chatId, ManagerState state) {
        managerState.put(chatId, state);
    }

    public synchronized static void setSearchState(String chatId, SearchState state) {
        searchState.put(chatId, state);
    }

    public static UState getState(String chatId) {
        return userState.get(chatId);
    }

    public static ManagerState getManagerState(String chatId) {
        if (Objects.isNull(managerState.get(chatId))) {
            setManagerState(chatId, ManagerState.UNDEFINED);
        }
        return managerState.get(chatId);
    }

    public static SettingsState getSettingsState(String chatId) {
        if (Objects.isNull(settingsState.get(chatId))) {
            setSettingsState(chatId, SettingsState.UNDEFINED);
        }
        return settingsState.get(chatId);
    }

    public static MenuState getMenuState(String chatId) {
        if (Objects.isNull(menuState.get(chatId))) {
            setMenuState(chatId, MenuState.UNDEFINED);
//            return menuState.get(chatId);
        }
        return menuState.get(chatId);
    }

    public static SearchState getSearchState(String chatId) {
        if (Objects.isNull(searchState.get(chatId))) {
            setSearchState(chatId, SearchState.UNDEFINED);
        }
        return searchState.get(chatId);
    }

    public static Integer getLimitState(String chatId) {
        if (Objects.isNull(limitState.get(chatId))) {
            limitState.put(chatId, 5);
        }
        return limitState.get(chatId);
    }

    public static void setLimitState(String chatId, Integer limit) {
        limitState.put(chatId, limit);
    }
}
