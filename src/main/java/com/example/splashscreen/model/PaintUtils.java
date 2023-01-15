package com.example.splashscreen.model;

public interface PaintUtils {
    enum Size {
        DEFAULT_WIDTH(600),
        DEFAULT_HEIGHT(400),
        DEFAULT_CANVAS_WIDTH(500),
        DEFAULT_CANVAS_HEIGHT(300);

        private final Integer size;

        Size(Integer size) {
            this.size = size;
        }

        public Integer get() {
            return this.size;
        }
    }
    enum PaintOptions {


        PAINT_BRUSH("paint");

        private static final PaintOptions[] options;

        private final String value;

        static {
            options = PaintOptions.values();
        }

        PaintOptions(String value) {
            this.value = value;
        }

        public static PaintOptions getOption(String text) {

            for (PaintOptions option : options) {

                if (option.get().equals(text))
                    return option;
            }
            return null;
        }

        public String get() {
            return value;
        }
    }

}
