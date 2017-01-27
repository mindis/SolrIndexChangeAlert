package com.prototype.utils;

import java.io.File;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;

import com.prototype.client.StompMessageClient;

/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



/**
 * 
 * @author mweigel
 *
 * A listener class with methods that are invoked when when Linux file events occur
 */
public class IndexChangeListenerImpl implements FileAlterationListener {

	private final StompMessageClient client;

	/**
	 * The single parameterized constructor 
	 * @param client - An instance of a StompMessageClient
	 */
	public IndexChangeListenerImpl(StompMessageClient client) {
		this.client = client;
	}


	/**
	 * The onStart method is called when FileAlterationObserver is started
	 */
	@Override
	public void onStart(final FileAlterationObserver observer) {
    	//System.out.println("IndexChangeListenerImpl: onStart()");
	}

	/**
	 * The onDirectoryCreate is called when a directory is created
	 */
	@Override
	public void onDirectoryCreate(final File directory) {
		try {
			String msg = "Directory - " + directory.getName() + " was created";
	    	client.sendMessage(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The onDirectoryChange method is called when a directory is changed
	 */
	@Override
	public void onDirectoryChange(final File directory) {
		try {
			String msg = "Directory - " + directory.getName() + " was changed";
	    	client.sendMessage(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The onDirectoryDelete method is called when a directory is deleted
	 */
	@Override
	public void onDirectoryDelete(final File directory) {
		try {
			String msg = "Directory - " + directory.getName() + " was deleted";
	    	client.sendMessage(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The onFileCreate method is called when a file is created
	 */
	@Override
	public void onFileCreate(final File file) {
		try {
			String msg = "File - " + file.getName() + " was created";
	    	client.sendMessage(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The onFileChange method is called when a file is changed
	 */
	@Override
	public void onFileChange(final File file) {
		try {
			String msg = "File - " + file.getName() + " was changed";
	    	client.sendMessage(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The onFileDelete method is called when a file is deleted
	 */
	@Override
	public void onFileDelete(final File file) {
		try {
			String msg = "File - " + file.getName() + " was deleted";
	    	client.sendMessage(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The onStop method is called when the FileAlterationObserver is stopped
	 */
	@Override
	public void onStop(final FileAlterationObserver observer) {
    	//System.out.println("IndexChangeListenerImpl: onStop()");
	}
}
