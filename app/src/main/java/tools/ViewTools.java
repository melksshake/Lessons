package tools;

import android.content.Context;
import android.widget.Toast;
import androidx.annotation.NonNull;

public class ViewTools {
  static public void showMessage(@NonNull Context context, @NonNull String message) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
  }
}
