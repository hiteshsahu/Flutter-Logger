# Flutter-Logger
> ## Awesome Logger For Flutter Apps

# Install: 

> Download & add the **AppLog.dart** File in Your Flutter App.

### Priority Level: VERBOSE<DEBUG<INFO<WARNING<ERROR<FAILURE

------

# Usage

### Input:

        AppLog.v("-----------------------------");
        AppLog.d("I am Debug Log With Default TAG");
        AppLog.i("I am Info Log With Default TAG");
        AppLog.w("I am Warn Log With Default TAG");
        AppLog.e("I am Error Log With Default TAG");
        AppLog.wtf("I am Failure Log With Default TAG");
        AppLog.v("I am Verbose Log With Default TAG");
        AppLog.v("-----------------------------");
        AppLog.d("I am Debug Log With Custom TAG", tag: "Awesome Widget");
        AppLog.i("I am Info Log With Custom TAG", tag: "Awesome Widget");
        AppLog.w("I am Warn Log With Custom TAG", tag: "Awesome Widget");
        AppLog.e("I am Error Log With Custom TAG", tag: "Awesome Widget");
        AppLog.wtf("I am Failure Log With Custom TAG", tag: "Awesome Widget");
        AppLog.v("I am Verbose Log With Custom TAG", tag: "Awesome Widget");
    AppLog.v("-----------------------------");

### Output:

    FlutterApp: -----------------------------
    DEBUG|FlutterApp: I am Debug Log With Default TAG
    INFOⓘ|FlutterApp: I am Info Log With Default TAG
    WARN⚠️|FlutterApp: I am Warn Log With Default TAG
    ERROR⚠️|️FlutterApp: I am Error Log With Default TAG
    WTF¯\_(ツ)_/¯|FlutterApp: I am Failure Log With Default TAG
    FlutterApp: I am Verbose Log With Default TAG
    FlutterApp: -----------------------------
    DEBUG|Awesome Widget: I am Debug Log With Custom TAG
    INFOⓘ|Awesome Widget: I am Info Log With Custom TAG
    WARN⚠️|Awesome Widget: I am Warn Log With Custom TAG
    ERROR⚠️|️Awesome Widget: I am Error Log With Custom TAG
    WTF¯\_(ツ)_/¯|Awesome Widget: I am Failure Log With Custom TAG
    Awesome Widget: I am Verbose Log With Custom TAG
    FlutterApp: -----------------------------

------------

# Set Application wide Log Levels to Hide DEBUG Logs

Use setLogLevel method to hide low prioriy logs from production code

>  ###  **AppLog.setLogLevel(priority);** 
>  ###  Where priority is always: **VERBOSE<=priority <= FAILURE**

### Input

    AppLog.setLogLevel(AppLog.WARN);
    AppLog.v("-----------------------------");
    AppLog.d("Debug Log Will not be Visible");
    AppLog.i("Info Log Will not be Visible");
    AppLog.w("Warn Log Will be Visible");
    AppLog.e("Error Log Will be Visible");
    AppLog.wtf("Failure Log Will be Visible");
    AppLog.v("Verbose Log  Will not be Visible");
    AppLog.v("-----------------------------");

### OutPut

    WARN⚠️|FlutterApp: Warn Log Will be Visible
    ERROR⚠️|️FlutterApp: Error Log Will be Visible
    WTF¯\_(ツ)_/¯|FlutterApp: Failure Log Will be Visible

