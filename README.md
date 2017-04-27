# Java Socket Multi-threaded Programming

We use Runnable interface's empty run() function to implement our logic. This logic contains socket for communication between different process on same machine.

Thread.start() invokes the run() method. Each client is connected to server on a different port. This is same as every tab of a browser has different port.
