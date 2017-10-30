/**
 * 分类已存在的异常，用于添加分类 的检查
 */
package win.mycorpus.exception;

public class CategoryExistException extends Exception {

	public CategoryExistException() {
		// TODO Auto-generated constructor stub
	}

	public CategoryExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CategoryExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CategoryExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CategoryExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
