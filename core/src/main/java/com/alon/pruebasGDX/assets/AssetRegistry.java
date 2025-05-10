package com.alon.pruebasGDX.assets;

import java.util.*;

public class AssetRegistry {
    private static final Map<String, Set<GameAsset>> assetsByScreen = new HashMap<>();
    private static String currentScreen = null;

    public static void registerScreenAssets(String screenName, GameAsset... assets) {
        Set<GameAsset> assetSet = assetsByScreen.computeIfAbsent(screenName, k -> new HashSet<>());
        Collections.addAll(assetSet, assets);
    }

    public static void loadScreenAssets(String screenName) {
        if (currentScreen != null) {
            unloadCurrentAssets();
        }

        currentScreen = screenName;
        Set<GameAsset> assetsToLoad = assetsByScreen.get(screenName);
        if (assetsToLoad != null) {
            for (GameAsset asset : assetsToLoad) {
                if (!Assets.assetManager.isLoaded(asset.getPath())) {
                    Assets.assetManager.load(asset.getPath(), asset.getAssetClass());
                }
            }
            Assets.assetManager.finishLoading();
        }
    }

    public static void unloadCurrentAssets() {
        if (currentScreen != null) {
            Set<GameAsset> assetsToUnload = assetsByScreen.get(currentScreen);
            if (assetsToUnload != null) {
                for (GameAsset asset : assetsToUnload) {
                    if (Assets.assetManager.isLoaded(asset.getPath())) {
                        Assets.assetManager.unload(asset.getPath());
                    }
                }
            }
            currentScreen = null;
        }
    }
}
