package com.example.edwardlucci.edwardzhihupaper.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.edwardlucci.edwardzhihupaper.bean.DailyStories;
import com.example.edwardlucci.edwardzhihupaper.bean.Story;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by edward on 16/6/26.
 */
public class DailyStoriesDeserializer implements JsonDeserializer<DailyStories> {
    @Override
    public DailyStories deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = (JsonObject) json;

        DailyStories dailyStories = new DailyStories();

        dailyStories.setDate(jsonObject.get("date").getAsString());

        List<Story> stories = context.deserialize(((JsonObject) json).get("stories"), new TypeToken<List<Story>>() {
        }.getType());

        dailyStories.setStories(stories);

        return dailyStories;
    }

    @Nullable
    protected static <T> List<T> getList(@NonNull JsonDeserializationContext context,
                                         @NonNull JsonObject jsonObject,
                                         @NonNull String memberName,
                                         @NonNull Type type) {
        try {
            if (jsonObject.has(memberName))
                return context.deserialize(jsonObject.get(memberName), type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}