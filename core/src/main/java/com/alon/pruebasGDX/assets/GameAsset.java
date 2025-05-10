package com.alon.pruebasGDX.assets;

public class GameAsset {
    private final String path;
    private final Class<?> assetClass;

    public GameAsset(String path, Class<?> assetClass) {
        this.path = path;
        this.assetClass = assetClass;
    }

    public String getPath() {
        return path;
    }

    public Class<?> getAssetClass() {
        return assetClass;
    }
}
