/** A concurrent computation that produces a value of type
 *  {@code V}. A computational task is implemented by
 *  inheriting this class and overriding the {@code call()}
 *  method.
 */
class Task<V> {
// Not to be called by clients:

  /** Returns: the result of this task. */
  protected abstract V call();

// For use inside the call() method:

  /** Returns: whether task was canceled. The implementation
   * of {@code call()} should use this method periodically
   * if another thread might cancel the task.
   */
  public boolean isCancelled();

  /** Effect: Report progress of the task. When workDone
   * reaches max, the task should be done. Progress can also
   * be reported using {@code Platform.runLater()}.
   */
  protected void updateProgress(long workDone, long max);

// For use by clients in other threads:

  /** Returns: the value computed by this thread. */
  V getValue();

  /** Effect: set the event handler to invoke when the task
   * completes successfully.
   */
  void setOnSucceeded(EventHandler<WorkerStateEvent> h);

  /** Effect: Cancel this task. */
  public void cancel();

  /** Returns: the fractional progress. */
  double getProgress();

  /** Returns: a property for the progress. */
  ReadOnlyDoubleProperty progressProperty();
}
