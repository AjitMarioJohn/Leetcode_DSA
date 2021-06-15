package com.questions.concept.enums;

import java.util.concurrent.TimeUnit;

public class EnumConcept {
    public static void main(String[] args) {
        Engine engine = new Engine(Engine.EngineType.TWO_STROKE_ENGINE);
        engine.start();
        engine.stop();

        engine = new Engine(Engine.EngineType.FOUR_STROKE_ENGINE);
        engine.start();
        engine.stop();
    }
}
