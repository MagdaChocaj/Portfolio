package fakestore.driver;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.BindingCallback;
import com.microsoft.playwright.options.Cookie;
import com.microsoft.playwright.options.FunctionCallback;
import com.microsoft.playwright.options.Geolocation;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class NewBrowserContext implements INewBrowserContext {

    private final BrowserContext browserContext;
    private Page currentPage;

    public NewBrowserContext(BrowserContext browserContext) {
        this.browserContext = browserContext;
    }

    @Override
    public void onBackgroundPage(Consumer<Page> handler) {

    }

    @Override
    public void offBackgroundPage(Consumer<Page> handler) {

    }

    public void onClose(Consumer<BrowserContext> consumer) {
        this.browserContext.onClose(consumer);
    }

    public void offClose(Consumer<BrowserContext> consumer) {
        this.browserContext.offClose(consumer);
    }

    @Override
    public void onConsoleMessage(Consumer<ConsoleMessage> handler) {

    }

    @Override
    public void offConsoleMessage(Consumer<ConsoleMessage> handler) {

    }

    @Override
    public void onDialog(Consumer<Dialog> handler) {

    }

    @Override
    public void offDialog(Consumer<Dialog> handler) {

    }

    public void onPage(Consumer<Page> consumer) {
        this.browserContext.onPage(consumer);
    }

    public void offPage(Consumer<Page> consumer) {
        this.browserContext.offPage(consumer);
    }

    @Override
    public void onWebError(Consumer<WebError> handler) {

    }

    @Override
    public void offWebError(Consumer<WebError> handler) {

    }

    public void onRequest(Consumer<Request> consumer) {
        this.browserContext.onRequest(consumer);
    }

    public void offRequest(Consumer<Request> consumer) {
        this.browserContext.offRequest(consumer);
    }

    public void onRequestFailed(Consumer<Request> consumer) {
        this.browserContext.onRequestFailed(consumer);
    }

    public void offRequestFailed(Consumer<Request> consumer) {
        this.browserContext.offRequestFailed(consumer);
    }

    public void onRequestFinished(Consumer<Request> consumer) {
        this.browserContext.onRequestFinished(consumer);
    }

    public void offRequestFinished(Consumer<Request> consumer) {
        this.browserContext.offRequestFinished(consumer);
    }

    public void onResponse(Consumer<Response> consumer) {
        this.browserContext.onResponse(consumer);
    }

    public void offResponse(Consumer<Response> consumer) {
        this.browserContext.offResponse(consumer);
    }

    @Override
    public Clock clock() {
        return null;
    }

    public void addCookies(List<Cookie> list) {
        this.browserContext.addCookies(list);
    }

    public void addInitScript(String s) {
        this.browserContext.addInitScript(s);
    }

    public void addInitScript(Path path) {
        this.browserContext.addInitScript(path);
    }

    @Override
    public List<Page> backgroundPages() {
        return List.of();
    }

    public Browser browser() {
        return this.browserContext.browser();
    }

    public void clearCookies() {
        this.browserContext.clearCookies();
    }

    @Override
    public void clearCookies(ClearCookiesOptions options) {

    }

    public void clearPermissions() {
        this.browserContext.clearPermissions();
    }

    public void close() {
        this.browserContext.close();
    }

    @Override
    public void close(CloseOptions options) {

    }

    public List<Cookie> cookies() {
        return this.browserContext.cookies();
    }

    public List<Cookie> cookies(String s) {
        return this.browserContext.cookies(s);
    }

    public List<Cookie> cookies(List<String> list) {
        return this.browserContext.cookies(list);
    }

    public void exposeBinding(String name, BindingCallback callback) {
        this.browserContext.exposeBinding(name, callback);
    }

    public void exposeBinding(String s, BindingCallback bindingCallback, BrowserContext.ExposeBindingOptions exposeBindingOptions) {
        this.browserContext.exposeBinding(s, bindingCallback, exposeBindingOptions);
    }

    public void exposeFunction(String s, FunctionCallback functionCallback) {
        this.browserContext.exposeFunction(s, functionCallback);
    }

    public void grantPermissions(List<String> permissions) {
        this.browserContext.grantPermissions(permissions);
    }

    public void grantPermissions(List<String> list, BrowserContext.GrantPermissionsOptions grantPermissionsOptions) {
        this.browserContext.grantPermissions(list, grantPermissionsOptions);
    }

    @Override
    public CDPSession newCDPSession(Page page) {
        return null;
    }

    @Override
    public CDPSession newCDPSession(Frame page) {
        return null;
    }

    public Page newPage() {
        this.setCurrentPage(this.browserContext.newPage());
        return this.currentPage();
    }

    public Page currentPage() {
        return Objects.isNull(this.currentPage) ? this.newPage() : this.currentPage;
    }

    public void setCurrentPage(Page page) {
        this.currentPage = page;
    }

    public List<Page> pages() {
        return this.browserContext.pages();
    }

    public APIRequestContext request() {
        return this.browserContext.request();
    }

    public void route(String url, Consumer<Route> handler) {
        this.browserContext.route(url, handler);
    }

    public void route(String s, Consumer<Route> consumer, BrowserContext.RouteOptions routeOptions) {
        this.browserContext.route(s, consumer, routeOptions);
    }

    public void route(Pattern url, Consumer<Route> handler) {
        this.browserContext.route(url, handler);
    }

    public void route(Pattern pattern, Consumer<Route> consumer, BrowserContext.RouteOptions routeOptions) {
        this.browserContext.route(pattern, consumer, routeOptions);
    }

    public void route(Predicate<String> url, Consumer<Route> handler) {
        this.browserContext.route(url, handler);
    }

    public void route(Predicate<String> predicate, Consumer<Route> consumer, BrowserContext.RouteOptions routeOptions) {
        this.browserContext.route(predicate, consumer, routeOptions);
    }

    public void routeFromHAR(Path har) {
        this.browserContext.routeFromHAR(har);
    }

    public void routeFromHAR(Path path, BrowserContext.RouteFromHAROptions routeFromHAROptions) {
        this.browserContext.routeFromHAR(path, routeFromHAROptions);
    }

    @Override
    public void routeWebSocket(String url, Consumer<WebSocketRoute> handler) {

    }

    @Override
    public void routeWebSocket(Pattern url, Consumer<WebSocketRoute> handler) {

    }

    @Override
    public void routeWebSocket(Predicate<String> url, Consumer<WebSocketRoute> handler) {

    }

    public void setDefaultNavigationTimeout(double v) {
        this.browserContext.setDefaultNavigationTimeout(v);
    }

    public void setDefaultTimeout(double v) {
        this.browserContext.setDefaultTimeout(v);
    }

    public void setExtraHTTPHeaders(Map<String, String> map) {
        this.browserContext.setExtraHTTPHeaders(map);
    }

    public void setGeolocation(Geolocation geolocation) {
        this.browserContext.setGeolocation(geolocation);
    }

    public void setOffline(boolean b) {
        this.browserContext.setOffline(b);
    }

    public String storageState() {
        return this.browserContext.storageState();
    }

    public String storageState(BrowserContext.StorageStateOptions storageStateOptions) {
        return this.browserContext.storageState(storageStateOptions);
    }

    public Tracing tracing() {
        return this.browserContext.tracing();
    }

    @Override
    public void unrouteAll() {

    }

    public void unroute(String url) {
        this.browserContext.unroute(url);
    }

    public void unroute(String s, Consumer<Route> consumer) {
        this.browserContext.unroute(s, consumer);
    }

    public void unroute(Pattern url) {
        this.browserContext.unroute(url);
    }

    public void unroute(Pattern pattern, Consumer<Route> consumer) {
        this.browserContext.unroute(pattern, consumer);
    }

    public void unroute(Predicate<String> url) {
        this.browserContext.unroute(url);
    }

    public void unroute(Predicate<String> predicate, Consumer<Route> consumer) {
        this.browserContext.unroute(predicate, consumer);
    }

    public void waitForCondition(BooleanSupplier booleanSupplier, BrowserContext.WaitForConditionOptions waitForConditionOptions) {
        this.browserContext.waitForCondition(booleanSupplier, waitForConditionOptions);
    }

    @Override
    public ConsoleMessage waitForConsoleMessage(WaitForConsoleMessageOptions options, Runnable callback) {
        return null;
    }

    public Page waitForPage(Runnable callback) {
        return this.browserContext.waitForPage(callback);
    }

    public Page waitForPage(BrowserContext.WaitForPageOptions waitForPageOptions, Runnable runnable) {
        return this.browserContext.waitForPage(waitForPageOptions, runnable);
    }
}

