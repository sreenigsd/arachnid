package com.gsd.sreenidhi.arachnid;

import org.junit.Ignore;
import org.junit.Test;
import com.gsd.sreenidhi.arachnid.model.AfterExtractor;
import com.gsd.sreenidhi.arachnid.model.annotation.ExtractBy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public class SimpleHttpClientTest {

    public static class Weather implements AfterExtractor {

        private String location;

        @ExtractBy(notNull = true, value = "//div[@id='7d']//ul[@class='t']/li[2]/p[@class='tem']/i/regex('([\\-\\d]+)',1)")
        private Integer lowTemperature;

        @ExtractBy(notNull = true, value = "//div[@id='7d']//ul[@class='t']/li[2]/p[@class='tem']/span/regex('([\\-\\d]+)',1)")
        private Integer highTemperature;

        @ExtractBy(notNull = true, value = "//div[@id='7d']//ul[@class='t']/li[2]/p[@class='wea']/text()")
        private String desc;

        @Override
        public void afterProcess(Page page) {
            if (lowTemperature > highTemperature) {
                int temp = lowTemperature;
                lowTemperature = highTemperature;
                highTemperature = temp;
            }
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Integer getLowTemperature() {
            return lowTemperature;
        }

        public void setLowTemperature(Integer lowTemperature) {
            this.lowTemperature = lowTemperature;
        }

        public Integer getHighTemperature() {
            return highTemperature;
        }

        public void setHighTemperature(Integer highTemperature) {
            this.highTemperature = highTemperature;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "Weather{" +
                    "location='" + location + '\'' +
                    ", lowTemperature=" + lowTemperature +
                    ", highTemperature=" + highTemperature +
                    ", desc='" + desc + '\'' +
                    '}';
        }
    }

    @Ignore
    @Test
    public void test() throws Exception {
        Weather weather = new SimpleHttpClient(Site.me()).get("http://www.weather.com/weather/101020100.shtml", Weather.class);
        assertThat(weather).isNotNull();
    }

}
