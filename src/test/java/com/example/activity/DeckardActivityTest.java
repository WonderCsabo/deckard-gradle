package com.example.activity;

import com.example.BuildConfig;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
@PrepareForTest(Static.class)
public class DeckardActivityTest {

    @Rule
    public PowerMockRule rule = new PowerMockRule();

    @Test
    public void testSomething() throws Exception {
        assertTrue(Robolectric.buildActivity(DeckardActivity.class).create().get() != null);
    }

    @Test
    public void testStaticMocking() {
        PowerMockito.mockStatic(Static.class);
        Mockito.when(Static.staticMethod()).thenReturn("hello mock");

        assertTrue(Static.staticMethod().equals("hello mock"));
    }
}