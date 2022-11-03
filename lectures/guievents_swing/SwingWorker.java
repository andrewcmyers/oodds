/** A SwingWorker encapsulates a computation task that executes on a background
 *  thread rather than on the event dispatch thread, computing a final result of
 *  type {@code T} and optionally producing a sequence of values of type {@code V}
 *  that can be processed by the event dispatch thread. It also supports reporting
 *  its progress toward completion.
 */
class SwingWorker<T,V> {
    /** Effect: Do the background computation associated with this task.
     *  This method is to be overridden by subclasses of SwingWorker.
     */
    protected abstract T doInBackground();

    /** Effect: some worker-specific action, to be performed on the event
     *  dispatch thread when the tasks completes. A worker implementation
     *  is expected to override this method to define how the user interface
     *  should respond to the computed result.
     */
    protected void done();

    /** Effect: Block until the task finishes, and then return its result.
     *  This method can be used without blocking the event dispatch thread once
     *  the task is known to be complete, e.g., from the done() method.
     */
    public T get()

    /** Effect: try to cancel this task. */
    public boolean cancel(boolean mayInterruptIfRunning)

    /** Returns: Whether this this task was canceled before it finished.
     */
    public boolean isCancelled()
    
    /** Returns: the progress of the task.
     */
    public int getProgress();

    /** Effect: Set the progress of the task. */
    void setProgress(int progress)/

    /** Effect: report a variable number of items to the event dispatch thread.
     *  Requires: called from the SwingWorker background thread.
     */
    protected void public(V... items);

    /** Effect: Receive previously published items and do something with them
     *    on the event dispatch thread. This method is automatically called
     *    with previously published items. By default this method does nothing;
     *    The definer of a SwingWorker subclass is expected to override it with
     *    new behavior.
     */
    protected void process(V... items);
}
