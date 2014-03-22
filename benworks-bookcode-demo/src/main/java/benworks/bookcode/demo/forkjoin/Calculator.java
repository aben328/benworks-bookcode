package benworks.bookcode.demo.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * 这段代码中，定义了一个累加的任务，在compute方法中，判断当前的计算范围是否小于一个值，如果是则计算，<br>
 * 如果没有，就把任务拆分为连个子任务，并合并连个子任务的中间结果。程序递归的完成了任务拆分和计算。
 * 
 * @author Ben
 */
public class Calculator extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 9218104487132712773L;
	private static final int THRESHOLD = 100;
	private int start;
	private int end;

	public Calculator(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		if ((start - end) < THRESHOLD) {
			for (int i = start; i < end; i++) {
				sum += i;
			}
		} else {
			int middle = (start + end) / 2;
			Calculator left = new Calculator(start, middle);
			Calculator right = new Calculator(middle + 1, end);
			left.fork();
			right.fork();

			sum = left.join() + right.join();
		}
		return sum;
	}

}
